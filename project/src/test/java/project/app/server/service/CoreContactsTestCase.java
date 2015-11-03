package project.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project.app.server.repository.CoreContactsRepository;
import project.app.shared.contacts.CoreContacts;
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
import project.app.shared.contacts.Gender;
import project.app.server.repository.GenderRepository;
import project.app.shared.location.Language;
import project.app.server.repository.LanguageRepository;
import project.app.shared.location.Timezone;
import project.app.server.repository.TimezoneRepository;
import project.app.shared.contacts.Title;
import project.app.server.repository.TitleRepository;
import project.app.shared.contacts.CommunicationData;
import project.app.shared.contacts.CommunicationGroup;
import project.app.server.repository.CommunicationGroupRepository;
import project.app.shared.contacts.CommunicationType;
import project.app.server.repository.CommunicationTypeRepository;
import project.app.shared.location.Address;
import project.app.server.repository.AddressRepository;
import project.app.shared.location.AddressType;
import project.app.server.repository.AddressTypeRepository;
import project.app.shared.location.City;
import project.app.server.repository.CityRepository;
import project.app.shared.location.Country;
import project.app.server.repository.CountryRepository;
import project.app.shared.location.State;
import project.app.server.repository.StateRepository;

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
            gender.setGender("Xy3JycF1p8NC9LgyVMYHdVA1CyGl0BStt5h1lIlgfWtAwNrUID");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("qM");
            language.setAlpha3("sXI");
            language.setAlpha4("QnDO");
            language.setAlpha4parentid(1);
            language.setLanguage("H5k0Yg2p8KCR9K4KOtbG0rn585YMxFwm2KyzMeuUzfehqRT9pF");
            language.setLanguageDescription("RqGDJHVVMHz0gKt2m0Lev71BFKkKnKblGh7uKxK3NZbQ0UNPg3");
            language.setLanguageIcon("uz1LFfN7oPteoIBmd7zHTS5XyP579YJbdOYw2dhatCS36n09Gy");
            language.setLanguageType("GAgdijhE91ZPtbIljNqG7pBPbLdwLtsG");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("pb6ItNX0SJw9YUae7TNaScA7IG8OZJokZ25cg7tiujOEGgVSA9");
            timezone.setCountry("yxzxIgCBA4mKqt67UNeOP67n7nKZbsY7UyAxFV1sZYSiDvQFnn");
            timezone.setGmtLabel("na0LjWzIuckySXsHs65XQmF9UJBQgXXH2nT8RSHvBUBoGsGBly");
            timezone.setTimeZoneLabel("2ya09HMWxU2wgFDcyJEAxe4dp0ba2Hdd8kNndwWxFEYt0cONGl");
            timezone.setUtcdifference(0);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("0EDRENOAygwxK0RYYYnGjMxTxnWGLdibkpxrjIjB6aYrIZaXQk");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(54);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("ibxSUGVXKrq4R5gdVhqZG4wHZ7vPGuXGw36L8kt7bMfhynpAQe");
            corecontacts.setFirstName("sfKsqYcSy84Pby0gdys9kbHUHwpsR1gIE94Gh60zuqTrJ1HS7m");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("qHDHYw1X25kfB3N1Uv6lJ93B4sdEHATHCqoTaTl7jJU1YLCpat");
            corecontacts.setMiddleName("AxTjlnjOqDLjNUWis323FrSZpM33eLqlg2h4k1NGepkOQYQUBr");
            corecontacts.setNativeFirstName("4jvKkpltS4Dh887UXfAmXJO2qKZy3uLzUtSesZbe7im2w8OjZK");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("Pu93V5lIJsqUevEzEDPRs9AKRN1JSsgd8VvjQUxHC1VSQrfgEU");
            corecontacts.setNativeMiddleName("eT7wU1QeyFjWAf872vnA6Q7lSTz8hiSlB97Vpk3MY22YBHTTiI");
            corecontacts.setNativeTitle("wW4C3NSIggJbziMGvsc8qe92khnBGZ0MXb0BDl2NpBhsuCibzP");
            corecontacts.setPhoneNumber("eZpgMnPRaIw5qor9V6Ov");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("hyT");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("aJltEQ1LZbT5tkkf6to8O1LKlALHq9vkyi7siGsz47GEcwUpAH");
            communicationgroup.setCommGroupName("BCYC7l9McXAKolefBdKBPgGf1r3R5q4PTpfwX2Z8AC6fChk79v");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("qeJDJMOGobXgRySi5QGWPbljfyyEeqxdMBvQd9QVHdf3ajHamA");
            communicationtype.setCommTypeName("buZjBpWpdTTvgXI54GffYJfGhE8lZlpbGAN06YLI2dkwqTmzTe");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("rLb");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("GxAA8wroORAFYOIkFRsYTysCk8cdL1Q8XUrWiE49I0p5zJsb9M");
            address.setAddress2("2ZRvjm651CoJqSXdEg6APGBjURCgEO8uomtOoq0YNxTvNf2SPu");
            address.setAddress3("GfQuILIyobffNIOUXMUnhyMUi51EcHukMvfDlYTy9kV9CdCnKL");
            address.setAddressLabel("KpoiFBRr8lW");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("24qd5LIV6vOyeg8OTrsyZ2RKsv9wZQY8y8chZxptM3rOegYOGn");
            addresstype.setAddressTypeDesc("D8jbYuvaNqlrHuomfynczkcaO9rYyLVu3dfa4gp3Ws652QstxU");
            addresstype.setAddressTypeIcon("QFGleAxn0I7OXmGboYepcUMybdMjELmMQxPrk1YkrS5Z5p553t");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("yncIdLeP9rg5DYOyWhbArr3TCz4Em1VH");
            city.setCityDescription("hDIue1DRKo2vMsJLZe7xyqPSRMzZd2ZBENghDINoCCHHftckpN");
            city.setCityFlag("a9s62rtcMwfyxWTx8usy8rD97g3rgxj1wTGNbHfa4y608eTmYE");
            city.setCityLatitude(5);
            city.setCityLongitude(11);
            city.setCityName("YjIsKAGEwZ4YzuXZGtYwMGRqMmlHHUSA914l4UMu6aZ5crwb4I");
            Country country = new Country();
            country.setCapital("3DkYER2OmQA72YDy3ABQLSMtyMbTKEn4");
            country.setCapitalLatitude(5);
            country.setCapitalLongitude(10);
            country.setCountryCode1("StM");
            country.setCountryCode2("h7o");
            country.setCountryFlag("VOtgZbTnZhqwFSyd55xsW5dnymJqpJH9PUwhA7gTE9BYn3BCcd");
            country.setCountryName("e9f5vjs0GTCOuvrI2QkgrwmFWe35DDtWhxGRPlnGlTNGx7mhZ5");
            country.setCurrencyCode("ipI");
            country.setCurrencyName("9dhPwivbdLT0tnwxy3bqeDKxoOZVxUkZ7X5TRN3ZaSA3p7KKh1");
            country.setCurrencySymbol("zs39zI7wmxhtXCGlHa9QYqjvetfayXPJ");
            country.setIsoNumeric(5);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("ixisJRvirRFoNVBfF2b3132J1rLhd4doNUw3lt94IklZzuUIHK");
            state.setStateCapitalLatitude(8);
            state.setStateCapitalLongitude(11);
            state.setStateCode(1);
            state.setStateCodeChar2("KEMYq9NJX6Xcg70P7poZS4k2VffNxlwL");
            state.setStateCodeChar3("iC2NFctrRetIPwdYq6MHbuTj7IyThpkW");
            state.setStateDescription("wq9JmS5X5wVdndEgjNBQP1TpnDpYdZDLZW6iSkaVr8hxdv1XgW");
            state.setStateFlag("E5EBrcjKCE6vfhlglO0wh4nviPBawlfTmyvmyDfdIOlCPsS2lN");
            state.setStateName("fKceh97lIOomw6fwcYYDRxJLbA0vAnnf0ATH9EeGJ5RLrZKQnN");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("cuOiBil2RqOrsrjAbP1uLXbkJgTuyxmy");
            city.setCityDescription("vZ4dHurETaOyVEn83p4GinOZr5p0523HlbnqlPPktKTKf1jDm3");
            city.setCityFlag("2t581j0uCjynz7qwdEDRwsuw3YGJvj0w47ZA2YodTyCOuR0gMO");
            city.setCityLatitude(3);
            city.setCityLongitude(11);
            city.setCityName("Fv4kuO1BtDjOcfTbnMUOAp15Zn73WxV9lSPYJXL0hkpkP2LbGM");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("HhunfglhXgL1XLt8WkJXvrdXFCnQ7KkkowQ5hYzTYSsnUvhLKj");
            address.setAddress2("zXsBQpANAK1AmQ2QyoDgyFkFIBdZNI8nIt3zuloEyLhoqkAh0y");
            address.setAddress3("96mldtHXuCC8Ny4QLOlTyZq3cBBbmTX0jI8CCQbV0qBpAOprjX");
            address.setAddressLabel("sSFkrRjC5k5");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("zA20pV3HS8ZoD6MIsWYOQt7ZPIA2YIxOKb57O5aYahpRqsCtc1");
            address.setLongitude("dlIMWyuxf0fh8NXHOW6c5biLi2aFJPYCaCMDdBNdkgxSiAQ9kA");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("N7sBuK");
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
            corecontacts.setAge(101);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("Twr7n4gU6tHQwApmpOhFkhitNwMRPn1WLTMclua9HrBLMZGEzk");
            corecontacts.setFirstName("OH5qAvIsx2n78R0MmY1DoTRDQYeOjISfY70pUn9FLwsPlmdy8z");
            corecontacts.setLastName("YQxvr6IB3tIiFh0dCbIENupErUYml3QTgpQpNhBWSF1Wcr6Egw");
            corecontacts.setMiddleName("3jccZfB0Wi2Oca4AjFckzlIqPlgY8Lt00dCIisC3B4LvZHmR44");
            corecontacts.setNativeFirstName("e6lsOE9FtUSwct9cVcraf7jz4e26mOqSrscFeTT0iWISWzorzF");
            corecontacts.setNativeLastName("IRicZc3DIPZOgPLb5qrNFiEC4othtdgdpwWOcD46LfUxSuc0c6");
            corecontacts.setNativeMiddleName("PA4CTU2bKTBSYEp145yWNWjbmOorahN7pnQPFL0cpvdm3WBTxE");
            corecontacts.setNativeTitle("XDe3DEeOWqEbKjL05ma8IZXDf51JNNQXge5sq81mPdEFgvQn27");
            corecontacts.setPhoneNumber("S93mqtFfJifxoYLOskyE");
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
