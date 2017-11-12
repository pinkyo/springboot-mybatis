package my.pinkyo.demo.controller;

import my.pinkyo.demo.App;
import my.pinkyo.demo.model.Sex;
import my.pinkyo.demo.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = App.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestControllerTest {
    @Autowired
    TestRestTemplate restTemplate;

    static final String baseUrl = "/test";
    String userName = "test";

    @Before
    public void setUp() throws Exception {
        User user = new User();
        user.setName(userName);
        user.setSex(Sex.MALE);

        restTemplate.postForEntity(baseUrl, user, String.class);
    }

    @Test
    public void testGetById() {
        User user = restTemplate.getForObject(baseUrl + "/{name}", User.class, userName);
        assertNotNull(user);
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setName(userName);
        user.setSex(Sex.FEMALE);

        restTemplate.put(baseUrl, user);
    }
}