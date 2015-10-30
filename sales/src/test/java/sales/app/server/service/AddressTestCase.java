package sales.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.AddressRepository;
import sales.app.shared.location.Address;
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
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("hJ0Nb4mLnAn9AUE2IKNhSQENiXrHuKPV31o7b27Fl6HyJWUNpn");
            addresstype.setAddressTypeDesc("0zH0Bgl9g6wjRkG1Qa0TpswqP6L5os3jjm6V4pCiws59Lagepc");
            addresstype.setAddressTypeIcon("XWH6ezhU6nRt8FGXMINC6ijW94Pv67aGSDUWXU8u3rHHiKAtnD");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("5dxIlIqSjyygx3KFCpgCzpQVA809yOd3");
            city.setCityDescription("mewADQrhF7L23JpxyA6sv8SfYYaVotohRr73ILxTaip8ltgN4b");
            city.setCityFlag("pfgMZzp4bGN5cWlZPzG4qdXk6BRezR45hhA0Yq1YrzbkKJ8I62");
            city.setCityLatitude(6);
            city.setCityLongitude(3);
            city.setCityName("DElwIqg2J99AbX7jg4Ksm0QJxU9E8pNvaYyuTZMvkTLITruQri");
            Country country = new Country();
            country.setCapital("gynWAyt6FNGqJSwRMHSEDSN9j0Tj4a7v");
            country.setCapitalLatitude(7);
            country.setCapitalLongitude(5);
            country.setCountryCode1("Drx");
            country.setCountryCode2("7Tl");
            country.setCountryFlag("3FdEw3h7belGDU7drjq9avp1Jhqr7Uz8GI2nY46HgNhXzNm4MN");
            country.setCountryName("kEaiREf7fRKGABQ48nBhnAPhXJXWieoMI3fbKmpkkrrsLjOfu5");
            country.setCurrencyCode("Jxo");
            country.setCurrencyName("KaZHE9nCjH5xjOGad9cgh8Cq6G0rR3YjkaqxFvls9NkHPa7eHd");
            country.setCurrencySymbol("IUbYNHroUj7H25r8fwf9eENQcwpc6aqq");
            country.setIsoNumeric(11);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("fpCSh78sJroAs3PqcVirOHxW6N6BKGujiVtfYtXs8UmEArb5I2");
            state.setStateCapitalLatitude(9);
            state.setStateCapitalLongitude(6);
            state.setStateCode(1);
            state.setStateCodeChar2("5gZGt5K31Fj3HIeI3LTP8x2wPA5BCiCm");
            state.setStateCodeChar3("Fk0nMZgeoFeOz6UpqTUX1d81IvxpLbp1");
            state.setStateDescription("htPKSSVZKhWBpngBfbJG95PgaiQs0BY402ui1K7LqKSQyCLF7C");
            state.setStateFlag("wGlj7KPG2HjEbKWd90ze3U6zxGvpUpcF3L1LfVWmSC42HNDViu");
            state.setStateName("B84MnVDFZdplVRkq3rXjFdyHUCzI2iwy37yGwE9NwAbRlnNwXM");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("uTHAppqyOWnoSEAk4qlDYDF22VHnMlzJ");
            city.setCityDescription("Jp4LuO9MYHALRJvu8FKHdvOULFDgmOUbuqvDQLv86jrn6jOHX1");
            city.setCityFlag("uuv2GkdSDtbm9y7hZe0gY2uqoS7fqWnxh4lXvBfMci5NN6AEZX");
            city.setCityLatitude(3);
            city.setCityLongitude(1);
            city.setCityName("8UeiBJtyVjnY3c1QRXciuPtTJdOerv3eDIdTcw67IafaT6Uzpf");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("p7cNjhDSI9iSvF7Ok1mLObOPHS405VWRfeyycxtV6i4lqcGYa5");
            address.setAddress2("i774vxOhSg29AfBEOXUnZVkC21KNDsYylaY1V5VLUbm2JI8znE");
            address.setAddress3("CWqfkrraHPlyMrcKxqzZ3Au4cSEPyLWmDnViKSgd4jqfPIgjfU");
            address.setAddressLabel("FZ3h58pa9Oz");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("BFTA3xg6WdMl1DvPyXzZX9gG2YUhJbZ4vU7iBofvBoEqZVmBh3");
            address.setLongitude("3Fr25rfCZD4Vq8bjPOAq7LDE7KUMwLAeFDfodPWzTIOpUhESkH");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("BZRyvg");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("7S8R9twzciEZ6Y15vqUrypYjbZkN6CNdDJ1hUrOBIr4UqGhhxf");
            address.setAddress2("MNcOcPdT7bqrWX8qp6d7TwXHNPUBmZpeHyc2DHypmk1LzMW6Ti");
            address.setAddress3("Kp9nlFXhchLI3VOFxF8Cp2PXrfIv7k9qmrXHR4ki8uiCelJmN7");
            address.setAddressLabel("Zu9og1sdmLg");
            address.setLatitude("h9KNZiW5rDqFN9CGU2tEUFFiCpkzE0f5wOeRpBxxRyKi2pNVEo");
            address.setLongitude("TyoYW9SrgCAZFie5dBR8w8t2CCg2ROIBM1BiYJOiAgPmT1G6ot");
            address.setVersionId(1);
            address.setZipcode("N8z3w2");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
