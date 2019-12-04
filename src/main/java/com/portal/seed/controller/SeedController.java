package com.portal.seed.controller;

import com.portal.seed.elevate.repo.ElevateRepository;
import com.portal.seed.payment.model.CreatePaymentRequest;
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

import java.math.BigInteger;
import java.util.Arrays;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class SeedController {
    @Autowired
    RestTemplate restTemplate;

    @Value("${payment.restURL}")
    String paymentURL;


    private UUID merchantId;
    private final OrganizationRepository portalRepo;
    private final ElevateRepository elevateRepo;
    private final UserRoleOrgRepository uroRepo;
    private  final PaymentTransactionRepository paymentTxnRepo;
    private  final PaymentIntentEntityRepository paymentIntentRepo;

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

        String result =  restTemplate.exchange(paymentURL+id, HttpMethod.GET, entity, String.class).getBody();
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
            value = "/payments",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public String createPayment() {
        CreatePaymentRequest in = makeRequest();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<CreatePaymentRequest> entity = new HttpEntity<CreatePaymentRequest>(in, headers);

        PaymentIntent payment = restTemplate.exchange(paymentURL+"intents/", HttpMethod.POST, entity, PaymentIntent.class).getBody();

        return "payment";
    }

    private CreatePaymentRequest makeRequest() {
        CreatePaymentRequest in = new CreatePaymentRequest();
        in.setAmount(BigInteger.TEN);
        in.setCurrencyCode("USD");
        in.setFirstName("SeedUserFirstName");
        in.setLastName("SeedUserLastName");
        in.setEmail("seed.user@portal.com");
        in.setGatewayId(UUID.fromString("f23da98a-c7aa-4637-962a-8c852e765e38"));
        in.setGatewayPaymentSourceToken("tok_visa");
        in.setMerchantId(UUID.fromString("47b70ca4-0f6e-4c52-819f-667ae804f9d2"));
        //in.setMerchantId(merchantId);
        in.setPaymentSourceConfigId(UUID.fromString("b1016af0-8b34-43b9-9e4d-940b4f53aeb3"));
        in.setPaymentSourceTokenId(UUID.fromString("98e11d34-4519-4668-b09d-85a3c6765989"));
        return in;
    }

    @DeleteMapping("/payments")
    public String  deletePayments() {
        paymentTxnRepo.deleteAll();
        paymentIntentRepo.deleteAll();
        return "deleted all";
    }
}
