package project.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project.app.server.repository.AddressRepository;
import project.app.shared.location.Address;
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
            addresstype.setAddressType("Xghi0TYVDKE96cJgdQdcy2ZxbAlQRAH5vDmaYzjB5rtnDxLc0I");
            addresstype.setAddressTypeDesc("JNoAo4j0O5mWiN0rySAs2UDuCLfCsUCQ6ojjWQNliYFJPtC969");
            addresstype.setAddressTypeIcon("L0cRalju9XML6rSx2ofWRowBvP65JruNaABYKTusRQZLwglRCZ");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("tjNdqa78LffANgJoyDXz72WnekDUfXK2");
            city.setCityDescription("khfeCQeiZz2jSfjStFLZZq0mAP7yQEl1x4VOJYXjf8TlL5dsEw");
            city.setCityFlag("m6KfWEN0mYm00kZIrcYhHeJuClcNEWQXoxzqP31ZkDyUcMaXtk");
            city.setCityLatitude(0);
            city.setCityLongitude(3);
            city.setCityName("CQrDBRwuwre7d0DNN4uBTca2o7ePJoHbZhgyYmhQsHrF0Ni9Kw");
            Country country = new Country();
            country.setCapital("03GMeYMkCcDc8a1ToNVwBs9WCXsieJpk");
            country.setCapitalLatitude(3);
            country.setCapitalLongitude(5);
            country.setCountryCode1("h43");
            country.setCountryCode2("dbt");
            country.setCountryFlag("73KmWkKnla15trv1rDhhlGYVr0Yb5oPFcm1nuUeLvKgSMSe8ET");
            country.setCountryName("EXBsSrR4cDHodWjC4ezvEIh2R2EWT8Qk36nEfuTjj3NCVeCCQB");
            country.setCurrencyCode("E54");
            country.setCurrencyName("rYluMCXHExnYtyigWCQSQukLvbFpJFatpPpoZ9N0i7UHszwz3f");
            country.setCurrencySymbol("6TA8qICOVGjDPdUyykWZ6o70VtytqxUI");
            country.setIsoNumeric(5);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("234uEazx5SVSKA44tYGcEbANYUyd82rsP7naZsSUjJIpkqTEsD");
            state.setStateCapitalLatitude(2);
            state.setStateCapitalLongitude(3);
            state.setStateCode(0);
            state.setStateCodeChar2("fHAK2BRosMJC48SNFXLNMFj3DZh9zS90");
            state.setStateCodeChar3("TRYqv6d3pDLUoMxgbCrhhTrRWtH9ztjl");
            state.setStateDescription("hd5FJKeEMVQw1jpw2ILgfK3ywgE5flo4STa3vp1K9oVZBl99ku");
            state.setStateFlag("r6rBuemVXroafSreubNWz6HpQnROSTyT203USEVFaTQ7QeZyMX");
            state.setStateName("NzqQtIBmP6NC9i5HRucaVPSTr2iyKcORRRzSFTwJpmSOzgWXqH");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("FIjog7xDo1677sryQX7p0uCPw6xAoo0o");
            city.setCityDescription("4KJA5TiLJ2vy0MmWMEym53NcpQKbtEWdAgGfamf8T4PmEshI0E");
            city.setCityFlag("jQ3N7aiJ8r2a7LYGuVZRSKvFYbQfWXxHGv3ykENcazDtX166xr");
            city.setCityLatitude(10);
            city.setCityLongitude(10);
            city.setCityName("faOCZ4juIlDGJj09rbEQWjQ1AkDsgk78r1QH4l2Xll0rzCCbv0");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("MuowwcETxD5tGGuCAQRXNNqrYUItlEEc554gy5Xmmv3WJ44Dxc");
            address.setAddress2("lixt2XxSNDA2e0YzDWCNPZPM6z2bZGHj51uGMRalMZB0W4TmRZ");
            address.setAddress3("a1OD4WFeG6lIaG284NxMSxEKtLGSkc9Ti10U8aHJqE6R2PBubg");
            address.setAddressLabel("7Y1DJAMBG8E");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("ZwsqHKBukdCUzJjcXLUNXdukUAvMkQym38k1BvQFyAmxrdwLvg");
            address.setLongitude("RGIoQDs7ElmLP0tIO51m5rJn1cas94cSJMRwrzV4qKAEcttQyC");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("rSJs2q");
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
            address.setAddress1("KKZpSnDveq5ukzq9Qzx7bwFYAlDtOgkOkIuJn8VvWRa8RRJ4NF");
            address.setAddress2("dVwGN65krZC0iatl7fwruzjsInGE7jIIZj3Z3CeGfnZynQoGcj");
            address.setAddress3("lMtuqC9xNy1Dr6950NEZitt3fpw6UYLLBlfCBmLAhvufY8DZtz");
            address.setAddressLabel("wjpGXyf37vR");
            address.setLatitude("ckm1m6FwLfDQxBChMg0si0povwfxCzewlFGDTlkyVX7C9mBX6C");
            address.setLongitude("UosnS2egpyV1V605bmY2EubxAQTMcChp0wpgQLWpjMoxjvXI2T");
            address.setVersionId(1);
            address.setZipcode("eY5fhl");
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
