package com.portal.seed.controller;

import com.portal.seed.controller.request.PaymentRequestBuilder;
import com.portal.seed.elevate.model.MerchantAssociationEntity;
import com.portal.seed.elevate.model.api.MerchantAssociation;
import com.portal.seed.elevate.repo.ElevateRepository;
import com.portal.seed.controller.request.CreatePaymentRequest;
import com.portal.seed.payment.model.api.FullRefundRequest;
import com.portal.seed.payment.model.api.Merchant;
import com.portal.seed.payment.model.api.PaymentIntent;
import com.portal.seed.payment.repo.PaymentIntentEntityRepository;
import com.portal.seed.payment.repo.PaymentTransactionRepository;
import com.portal.seed.portal.repo.OrganizationRepository;
import com.portal.seed.portal.repo.UserRoleOrgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class SeedController {
    @Autowired
    RestTemplate restTemplate;

    @Value("${payment.restURL}")
    String paymentURL;

    @Value("${elevate.restURL}")
    String elevateURL;

    public static final String ORG_ID = "1008";
    public static final String MERCHANT_ID = "5cc59b1e-4872-4700-96b0-12ace486bd14";

    private UUID merchantId;
    private final OrganizationRepository portalRepo;
    private final ElevateRepository elevateRepo;
    private final UserRoleOrgRepository uroRepo;
    private  final PaymentTransactionRepository paymentTxnRepo;
    private  final PaymentIntentEntityRepository paymentIntentRepo;
    PaymentRequestBuilder requestBuilder = new PaymentRequestBuilder();

    @Autowired
    SeedController(OrganizationRepository portalRepo, ElevateRepository elevateRepo, UserRoleOrgRepository
                   uroRepo, PaymentTransactionRepository paymentTxnRepo, PaymentIntentEntityRepository paymentIntentRepo) {
        this.portalRepo = portalRepo;
        this.elevateRepo = elevateRepo;
        this.uroRepo = uroRepo;
        this.paymentTxnRepo=paymentTxnRepo;
        this.paymentIntentRepo = paymentIntentRepo;
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @GetMapping(value = "/merchants/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String getMerchant(@PathVariable String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String result =  restTemplate.exchange(paymentURL+"merchants/"+id, HttpMethod.GET, entity, String.class).getBody();
        return result;
    }


    @GetMapping("/health")
    public String getStatus() {
        return "Seed app is healthy!";
    }

    @PostMapping("/org")
    public String createOrganization() {
//        Organization org = new Organization();
//        org = portalRepo.save(org);
//
//        UserRoleOrgAssociation orgAssociation = new UserRoleOrgAssociation();
//        orgAssociation.setOrgId(org.getId());
//        uroRepo.save(orgAssociation);

        Merchant merchant = createMerchant();
        merchantId = merchant.getId();

//        MerchantAssociation merchantAssociation = new MerchantAssociation();
//        merchantAssociation.setOrgId(org.getId().toString());
//        merchantAssociation.setMerchantId(merchant.getId().toString());
//        merchantAssociation = elevateRepo.save(merchantAssociation);

        //TODO create paymententity
        //createPayment();
        return "Hello World!";
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(
            value = "/merchants",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Merchant createMerchant() {
        Merchant merchant = new Merchant();
        merchant.setName("Seed Merchant");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Merchant> entity = new HttpEntity<Merchant>(merchant, headers);

        merchant  =   restTemplate.exchange(paymentURL+"merchants", HttpMethod.POST, entity, Merchant.class).getBody();
        return merchant;
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(
            value = "/payment",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String createSinglePayment() {
        CreatePaymentRequest in = requestBuilder.makeRequest();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<CreatePaymentRequest> entity = new HttpEntity<CreatePaymentRequest>(in, headers);

        PaymentIntent payment = restTemplate.exchange(paymentURL+"intents/", HttpMethod.POST, entity, PaymentIntent.class).getBody();

        return "payment";
    }



    @DeleteMapping("/merchant")
    public String  deleteMerchant() {
        MerchantAssociationEntity merchantAssociation = elevateRepo.findByOrgId(ORG_ID);
        if(merchantAssociation!=null){
            elevateRepo.deleteById(merchantAssociation.getMerchantId());
            paymentTxnRepo.deleteByMerchant(UUID.fromString(merchantAssociation.getMerchantId()));
            paymentIntentRepo.deleteByMerchant(UUID.fromString(merchantAssociation.getMerchantId()));
        }
        return "deleted all";
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(
            value = "/merchantmap",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public MerchantAssociationEntity createMerchantAssociation() {
        MerchantAssociationEntity merchantAssociation = new MerchantAssociationEntity();
        merchantAssociation.setMerchantId(MERCHANT_ID);
        merchantAssociation.setOrgId(ORG_ID);
        merchantAssociation = elevateRepo.save(merchantAssociation);
        return merchantAssociation;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(
            value = "/payments",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String createPayments() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<CreatePaymentRequest> entity;
        PaymentIntent payment;
        List<CreatePaymentRequest> paymentList = requestBuilder.getPayments();

        HttpEntity<FullRefundRequest> refundEntity;

        for(CreatePaymentRequest in: paymentList){
            entity = new HttpEntity<CreatePaymentRequest>(in, headers);
            payment = restTemplate.exchange(paymentURL+"intents/", HttpMethod.POST, entity, PaymentIntent.class).getBody();
            paymentIntentRepo.updatePayment(in.getCreatedDate(), payment.getId());
            paymentTxnRepo.updatePaymentTxn(in.getCreatedDate(), payment.getResultingTxn().getId());
            if(in.getIsRefund()){
                FullRefundRequest refund = new FullRefundRequest(UUID.fromString(MERCHANT_ID),payment.getResultingTxn().getId());
                refundEntity = new HttpEntity<FullRefundRequest>(refund, headers);
                refund = restTemplate.exchange(paymentURL+"refund/", HttpMethod.POST, refundEntity, FullRefundRequest.class).getBody();
            }
            else
                paymentIntentRepo.updatePaymentStatus(in.getStatus(), payment.getId());
        }
        return "payment";
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(
            value = "/seed",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String seedData() {
        deleteMerchant();
        createMerchantAssociation();
        createPayments();
        return "Seeding complete!";
    }
}
