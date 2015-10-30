package sales.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.CoreContactsRepository;
import sales.app.shared.contacts.CoreContacts;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import sales.app.shared.contacts.Gender;
import sales.app.server.repository.GenderRepository;
import sales.app.shared.location.Language;
import sales.app.server.repository.LanguageRepository;
import sales.app.shared.location.Timezone;
import sales.app.server.repository.TimezoneRepository;
import sales.app.shared.contacts.Title;
import sales.app.server.repository.TitleRepository;
import sales.app.shared.contacts.CommunicationData;
import sales.app.shared.contacts.CommunicationGroup;
import sales.app.server.repository.CommunicationGroupRepository;
import sales.app.shared.contacts.CommunicationType;
import sales.app.server.repository.CommunicationTypeRepository;
import sales.app.shared.location.Address;
import sales.app.server.repository.AddressRepository;
import sales.app.shared.location.AddressType;
import sales.app.server.repository.AddressTypeRepository;
import sales.app.shared.location.City;
import sales.app.server.repository.CityRepository;
import sales.app.shared.location.Country;
import sales.app.server.repository.CountryRepository;
import sales.app.shared.location.State;
import sales.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            Gender gender = new Gender();
            gender.setGender("tE1IFJ3UgekdYrog3KLzvWEKXSIKHvnyf2tnGuIOVOf1m1NMun");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("JP");
            language.setAlpha3("NhH");
            language.setAlpha4("v8NN");
            language.setAlpha4parentid(8);
            language.setLanguage("wiBfGgn0BR4tcY3gnQicj2TXYUu1sZTKyDSXj8Ns4Tw4p2vV72");
            language.setLanguageDescription("ALpPK29zAAXXXIMdvR5gPEqtldNiFNUv7v62jmx9VteMqvirnj");
            language.setLanguageIcon("AXogFPJlq6bhLALEsOWtIo1RTkLM18OfAyzL6GSZJIzeGMxKMk");
            language.setLanguageType("UzpeqXcmJm4zNicNzkgCOTpyMceaDd5y");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("nvBySjcXSe5WMjfrDuAYbQ4z4LFcp4lExIxKW5DqLoxno5R0Tu");
            timezone.setCountry("3y011ZYwBYBvsGS3pIbaG9G7MLbEaRUCR6eFhntagIiRjxYyOf");
            timezone.setGmtLabel("BCROYpQ1rc16gReIYqHpte2OVDlSDkykoVwqvxLVCBIBdEltH0");
            timezone.setTimeZoneLabel("FjzHkGZTo8Yz25IFEGaM7j7PBRxMOfrHu4HeAHTHnyvvBQ0kzZ");
            timezone.setUtcdifference(5);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("WL5dMqbnRVH40rHRkMdFgBksIxrtWGa9mUzTLo5W3Uer2rkM7K");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(124);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("j4acxhjMF5Glcau5WcWG9545rZLyW2b4tn1ytCUW4esASWvUzi");
            corecontacts.setFirstName("bOI6pdhj8BIT008wrKuNlV5ICJayrYZqPNLnMBLgExnXqVNG5X");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("o4eiAO5z7FJ9SuUYYyaNTkhQy7jbQz2XkyMtK4b80FKswkH5WB");
            corecontacts.setMiddleName("FJC5uWqrkB48ODdrrkU8SO21H5g5r01izcrISkwdUfpal8ZUiD");
            corecontacts.setNativeFirstName("GXNm0eZJmv4R6TwqIbbgFD9v3APvRKFy8yiOo5Qm8fiv1DrBlH");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("YGH8IBvbCtd9FBhvPBxT8N4k3rSklT09rwh9UwPvnUrwgitFPQ");
            corecontacts.setNativeMiddleName("uUAqcEGOKszgzdCKmUOKUBAM9pwZy90OIh4wT4TaXXtHA0zP6j");
            corecontacts.setNativeTitle("u7LcFJhk4U6qXUvKM2xRZzqEdGFTxxn7hvCuI54uXQPKxuWoIK");
            corecontacts.setPhoneNumber("5tAfd0At1sFCYoIj9kh3");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("mbZ");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("SC2XMJbKwyd217FWtD9EtpApede3Cp1l6azpLfpNQY8hAtSXQ9");
            communicationgroup.setCommGroupName("l6UOQ7bUWxRfxi1nwblRNACd1ZA430nEGkRydbukcByZBnEQt9");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("MhP8N5WvwQhGXRPZZdya5Axp1Zi2nJEQzamG1MuJUvZ7Lz1km4");
            communicationtype.setCommTypeName("s4bEj0KW5F4CLo0eJgkx5VoqgxD1l8Qf0lXtcrFKbkO4SXfQ7L");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("jtW");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("ra9G96mBVqWlGxQyelIhDgX5I1715oTu7d7ETRUsSnef4jvWXB");
            address.setAddress2("64mcwj3WvmuOfHvqr5qgDMsduCGj6oUpSzel4FivE40OayOxsO");
            address.setAddress3("bxye5VC2qFiqD8NVwVWQl8WIox38eHXNK2AVhStT0n4GUPGrQd");
            address.setAddressLabel("7gxsMCAo3Wu");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("ZiadJHW17gGMa4kvu2io0CiBkBtJAPxzZQZQDzwfwVo5pmwo2K");
            addresstype.setAddressTypeDesc("XFH1mmIQusY9yDGZkYRSZBroESOEpVGkVnSImj12ebLgSyDoWh");
            addresstype.setAddressTypeIcon("h8YMGQnIW5Kl0AUyCZ3k1wJTh6uFiOds3gPWpsjfKIvnQjWHhK");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("GCgApCkRfF7lDbpPfBH5GgicJ5iOjVuy");
            city.setCityDescription("LML9cAwuxnMwfMMZ5GY9c7Hxra0VSWS6zdXNcWPTDaHrDi4OnC");
            city.setCityFlag("t0wjIDFuLYXtJ4bdawequnaNVCfj8DqEXGbiuSOyXwSA4Mfpzl");
            city.setCityLatitude(1);
            city.setCityLongitude(7);
            city.setCityName("9z1D9B8esA3ZnbMbsa0mjWg18BgTUMxXpPVLeHaL44NphzuiPx");
            Country country = new Country();
            country.setCapital("ES4OmWyi6tmSwy5zUDceZBne0aRccX2I");
            country.setCapitalLatitude(5);
            country.setCapitalLongitude(11);
            country.setCountryCode1("eug");
            country.setCountryCode2("cwf");
            country.setCountryFlag("WtMLYWjQHepo33SQDbtY2cGxBVuniwP15j6S5YwrFIIWw0Ozhp");
            country.setCountryName("jjUjGPlYyPlvlB3WQynrCCP1FPpIQn1o3GlsLmCFYVU1EIKJT8");
            country.setCurrencyCode("aZt");
            country.setCurrencyName("PgOeusRp2V2Jf0lujYiGYEcf1A9hkXeSXIUCv2UUhRezRGdsZb");
            country.setCurrencySymbol("0kIrhBpzSKtm78ye9taWedkGq0dHVz7J");
            country.setIsoNumeric(8);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("HpkOhV1IAR0Evdf47PIYb9G0yA3hXdSF3AyS0vCFAetUCesTbu");
            state.setStateCapitalLatitude(0);
            state.setStateCapitalLongitude(9);
            state.setStateCode(2);
            state.setStateCodeChar2("fGFDFIBTiRfTd93T8ud1R4M8ApRSgehp");
            state.setStateCodeChar3("AMLTKj8ytdmYRhFn1BXAprxLP2UkAjrm");
            state.setStateDescription("mtqbCA9N6QprlJPXRf6aueaB2bAyLIkrp2WQ4vEm5fQjPrhcVv");
            state.setStateFlag("MR6kUWTj4yeQsfI7kOirahVCnWO4z85wC3aBWeQJGoMbYuCuZf");
            state.setStateName("WkJBdIl9OMBTDDNPeRRoLSOFIYrqLwdN1KHdtOB5EJIZPpd2fY");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("ltxBk1ThUqfHeS129hzRfuJbFF2jWbyN");
            city.setCityDescription("QgqOn54K7qh1ney6gkudZOZuiVBX5Upcv5ikTgLbkzGHqAfnJ3");
            city.setCityFlag("tGGDn0JWnwL0okzfoKqmYMcVo1eye3C4redjyL7hWw94QRXVab");
            city.setCityLatitude(6);
            city.setCityLongitude(8);
            city.setCityName("TJvPRZpBbRLjamHHAkx7LfxSS82bDvkyIZKSMMEB3jUFuy35F1");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("yGI3PV7DcD7z9QWZVUC8CIRp7lcW6nCEmf5pjKqGgr7wHRxGGq");
            address.setAddress2("JtSOxZlh4I2KvX25WswOZROmBXVc0Bmc9FFH3Urz3RcLRaI8Fs");
            address.setAddress3("hOPA9cPAnuMV0ztEhI2XqX4QaKgFFIsvMBogXjIPBIMsftkXqt");
            address.setAddressLabel("5yJ6JSI0GUB");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("oWsL99jfb8DBaesd8IFBos4tI17KZnmE2JemcYemeMKdTspyuc");
            address.setLongitude("Zw2Jd0v45rOArMMzoMlngL2USULdK98SeGRJU6RJtdkIPm4UM0");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("tJujUV");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(60);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("evwjEh3jM2248vnk7zL0WAz7lBBPJ7f3tcjGywMJceQ27EI80u");
            corecontacts.setFirstName("W41AvQTeDdmp1ed4nQt0SA6ZeUxtaoejcbZw6bvjZDzj2Q3KIP");
            corecontacts.setLastName("58zmzKqU9meygQTuxmPINBOFpFTeojcLJaRzTWkf44k5MSf8Av");
            corecontacts.setMiddleName("t60U9igZmiGpCwVtzgEOnJrP46Nidb1pwF2sCE9OH2MfxSQjnM");
            corecontacts.setNativeFirstName("mcHK5VNexDwpDSiPHrbqms7JO1L8Y81LfJBZaIGvV05KAu8D99");
            corecontacts.setNativeLastName("pU83ZhgtMAYWikRYWryyZpwbe3GJWBoHdFwZ1OWLh6liQSqm0U");
            corecontacts.setNativeMiddleName("SNOXAlxaesKIMnmkVeRvX37TMpBSK66VD70RcptvmBlm9wurIt");
            corecontacts.setNativeTitle("uG9izOKZlO9ImHyFpbVOb9EuY6FrXpekzNHup6KuIUbfdyJfjG");
            corecontacts.setPhoneNumber("TJuhTRTR2QyjutQLTmNF");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBytimeZone() {
        try {
            java.util.List<CoreContacts> listoftimeZone = corecontactsRepository.findByTimeZone((java.lang.String) map.get("TimezonePrimaryKey"));
            if (listoftimeZone.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
