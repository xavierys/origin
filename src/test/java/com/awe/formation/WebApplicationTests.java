package com.awe.formation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.http.client.MockClientHttpRequest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpSession;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by dzialoszynski on 28/05/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@WebAppConfiguration
public class WebApplicationTests {
    @Autowired
    private WebApplicationContext applicationContext;

    @Autowired
    private MockServletContext servletContext;

    @Autowired
    private UserService userService;

    @Autowired
    private MockHttpSession mockHttpSession;

    @Autowired
    private MockHttpServletRequest mockHttpServletRequest;



    @Test
    public void testWebApp() {
        assertNotNull(applicationContext);
        assertNotNull(servletContext);
        applicationContext.getServletContext();
    }

    @Test
    public void testScopedBeans(){
        mockHttpServletRequest.setParameter("username", "xavier dzialoszynski");
        mockHttpServletRequest.setParameter("password", "pass");
        mockHttpSession.setAttribute("theme", "dark");

        assertEquals("xavier dzialoszynski", userService.getLoginAction().getUserName());
        assertEquals("pass", userService.getLoginAction().getPassword());
        assertEquals("dark", userService.getUserPreferences().getTheme());

    }
}
