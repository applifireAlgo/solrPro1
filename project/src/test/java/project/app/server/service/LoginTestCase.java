package project.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project.app.server.repository.LoginRepository;
import project.app.shared.authentication.Login;
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
import project.app.shared.contacts.CoreContacts;
import project.app.server.repository.CoreContactsRepository;
import project.app.shared.contacts.Gender;
import project.app.server.repository.GenderRepository;
import project.app.shared.location.Language;
import project.app.server.repository.LanguageRepository;
import project.app.shared.location.Timezone;
import project.app.server.repository.TimezoneRepository;
import project.app.shared.contacts.Title;
import project.app.server.repository.TitleRepository;
import project.app.shared.authentication.User;
import project.app.server.repository.UserRepository;
import project.app.shared.authentication.UserAccessDomain;
import project.app.server.repository.UserAccessDomainRepository;
import project.app.shared.authentication.UserAccessLevel;
import project.app.server.repository.UserAccessLevelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(111);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("vSH8u6tVhFAj3U7Nu6PTb68Vyzxe39D2xDWd2wpMgj9lX7Tw6Z");
            corecontacts.setFirstName("dKumejjIE31PFq3cl6Yv0VW2EEmW4ejeLWWm9Pt1y65qHeNYk3");
            Gender gender = new Gender();
            gender.setGender("EWfMN5MgIxESB2udSFHkegOHIIVYNVWmljEp5kSlIsIr7MuNaL");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("Rm");
            language.setAlpha3("o4P");
            language.setAlpha4("jCvA");
            language.setAlpha4parentid(0);
            language.setLanguage("VLL4w3FjdJCQN6JY1iTfwFlQu4oUDRknxEqWakEzIgDMTAAM6m");
            language.setLanguageDescription("B8S8WRXO3CQllZPtgIT9GP6wTQjFKUF0D77DpqMbNtoVQuldy4");
            language.setLanguageIcon("5f7Pj5SRfW7UE9snzIa6q7ofBKlrmE4a8mH28XRcqYWoULFhu1");
            language.setLanguageType("epcDbmp0kwzt3wEbwbpcNYmSy3XRcSuf");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("XMM3KVm9xH7xF6GRqqYvEa81HEGEPWtd0dWahegSj51WTkpa3F");
            timezone.setCountry("rgDXw1VETq5dw3ihu2T0bYKP5ZXXhGiGgZNEYEh7C0gqSdgvSh");
            timezone.setGmtLabel("jqoq1hwMxXLnyxjs3ObVWD93nXeeTu7xboZRqLo4pax47YI7Pc");
            timezone.setTimeZoneLabel("JB3qpx0iVh2gvJRhw5cO3t8nEyIE1lY4dpve5QoYtweOmDBcYh");
            timezone.setUtcdifference(5);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("7MTZeux7xJHBDZaCvetlpyxtsYIKauG2SkDb6q8KIhR4e6k6Ak");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(99);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("VFPGj9JK9NEtgHFwZm8OL1zFf5MGgKiqWYWqrdWiFfQ1WRsp3s");
            corecontacts.setFirstName("oEeq3ZpStr8tTAxIgVu1JADlroT84HCSPMVxxdJCei1kTtER8C");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("fZ9ys7sKhVUlUBlLWSlFyeJs37o0IeiFDVtDlzximeqcTyAMvl");
            corecontacts.setMiddleName("Okg43UKyQc9FYrLA2PYfm1jcLUVoADzqAUT8BFZixZvhHUTji9");
            corecontacts.setNativeFirstName("jLk14t8edBJwIzHvgehMG3xzX64rLIBhhWwNx6DbuLFooFKjly");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("oQIHRlBodDzofshFXGeioeuXMivgD4JgoKdOuU6vqjeNa1bPzC");
            corecontacts.setNativeMiddleName("GMyFq3CU08C3tr5rHpcLWrT3NOT6qiRuQElKox21cDm9qkKUtk");
            corecontacts.setNativeTitle("4xdfnschETMYEFmu41a6vri6iFeJV4b1j4fNW87skKSa25aTCY");
            corecontacts.setPhoneNumber("MMyKIHiYlvQ4A7TC8fN4");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("JxIJXrRU365CAVM6WJd7N6KzqxVmd1O2ACKbISzd9cTBdMyP28");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(3201);
            user.setUserAccessCode(9);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("wLmqduizFThtsatJDJeG9HRPnIJXhUQvQ05ZnLNDR9Uk0Lcpcr");
            useraccessdomain.setDomainHelp("zzRjvCtM7gKVRb2ldpcmjuRq3UPDEb36XSKIDce6eEX0d0no2t");
            useraccessdomain.setDomainIcon("IKi2IvH5N1ng2MjESD4oCfwZWG5g7LGBcQRW8EA5eQGL4lBZG3");
            useraccessdomain.setDomainName("MvFkVlf5yvQu3n2GYrpn2SFpW2oYavWPPLceHJhGix1QKZVhOK");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("wmwLx7GCnG8hHa3XomlNYKic57wSvoIAb546y6EOTxxJ9rMGYo");
            useraccesslevel.setLevelHelp("kLhsKqUfkeIyuRxtOJbRc6ZQsn4YSg3V62s7SosuFBAKb1T0L9");
            useraccesslevel.setLevelIcon("WKRRUJO5MCskT39oUCMxqO0uLDg1YCUoDxIAZLtG74nT2yHbLS");
            useraccesslevel.setLevelName("yHyWnDTdzTUBXxOU6I1avP9ruPZwrvzdaxAb7zufIPNn6Y3v9q");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("9aQAJyxX05KzIXP5fe29ecps0dLYbAvgNv1pIvP5XTHE7UgGW2");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(3181);
            user.setUserAccessCode(11);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(3);
            login.setIsAuthenticated(true);
            login.setLoginId("jcaMyzXSl8lK3obcC3Nh0489V6JMKTFqs1ZoUqpzfXw8t09iA1");
            login.setServerAuthImage("xfFu9mzZGoGacoghIi3OfBjF7PgjNnDu");
            login.setServerAuthText("5BQwVEzhbxc9MkQk");
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(5);
            login.setLoginId("nHzJ4yV9Logne687tTQSe8mBGd0baJBWGJH40lc4LcS9KmOcZ3");
            login.setServerAuthImage("M7bFUGkvEA7yhIXCm0XPsjNo6rrBMRtL");
            login.setServerAuthText("6hX92BEtId8FWvxA");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycontactId() {
        try {
            java.util.List<Login> listofcontactId = loginRepository.findByContactId((java.lang.String) map.get("CoreContactsPrimaryKey"));
            if (listofcontactId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findByuserId() {
        try {
            java.util.List<Login> listofuserId = loginRepository.findByUserId((java.lang.String) map.get("UserPrimaryKey"));
            if (listofuserId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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
