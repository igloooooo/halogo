package au.com.halogo.web.rest;

import au.com.halogo.HalogoApp;
import au.com.halogo.security.AuthoritiesConstants;
import au.com.halogo.service.dto.TransformMessageReq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@WithMockUser(authorities = AuthoritiesConstants.ADMIN)
@SpringBootTest(classes = HalogoApp.class)
public class TransformControllerIT {
    private static final String TEST_123_45_WORD = "ONE HUNDRED AND TWENTY-THREE DOLLARS AND FORTY-FIVE CENTS";
    private static final String TEST_0_WORD = "ZERO CENT";
    @Autowired
    private MockMvc restUserMockMvc;

    @Test
    public void convertNumber() throws Exception {
        TransformMessageReq req = new TransformMessageReq();
        req.setUsername("nzhu");
        req.setNumber(123.45f);
        restUserMockMvc.perform(post("/api/transform")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(req)))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.word").value(TEST_123_45_WORD));
    }

    @Test
    public void convertNumberWithZero() throws Exception {
        TransformMessageReq req = new TransformMessageReq();
        req.setUsername("nzhu");
        req.setNumber(0f);
        restUserMockMvc.perform(post("/api/transform")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(req)))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.word").value(TEST_0_WORD));
    }

    @Test
    public void convertNumberWithLargeThanMillion() throws Exception {
        TransformMessageReq req = new TransformMessageReq();
        req.setUsername("nzhu");
        req.setNumber(1100000f);
        restUserMockMvc.perform(post("/api/transform")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(req)))
            .andExpect(status().isBadRequest());
    }

    @Test
    public void convertNumberWithLessThanZero() throws Exception {
        TransformMessageReq req = new TransformMessageReq();
        req.setUsername("nzhu");
        req.setNumber(-11f);
        restUserMockMvc.perform(post("/api/transform")
            .contentType(TestUtil.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(req)))
            .andExpect(status().isBadRequest());
    }
}
