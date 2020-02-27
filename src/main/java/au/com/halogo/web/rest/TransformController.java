package au.com.halogo.web.rest;

import au.com.halogo.service.TransformService;
import au.com.halogo.service.dto.TransformMessageReq;
import au.com.halogo.service.dto.TransformMessageRsp;
import au.com.halogo.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
public class TransformController {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private TransformService transformService;

    @PostMapping("/transform")
    public ResponseEntity<TransformMessageRsp> createUser(@Valid @RequestBody TransformMessageReq transformMessageReq) throws URISyntaxException {
        log.debug("REST request to transform message : {}", transformMessageReq);

        if (transformMessageReq.getUsername() != null
            && !(transformMessageReq.getNumber() < 0 || transformMessageReq.getNumber() > TransformService.MAX_VALUE.floatValue())) {
            BigDecimal money = BigDecimal.valueOf(transformMessageReq.getNumber()).setScale(2, BigDecimal.ROUND_HALF_UP);
            TransformMessageRsp rsp = new TransformMessageRsp();
            rsp.setUsername(transformMessageReq.getUsername());
            rsp.setWord(transformService.convertNumberToWord(money));
            return new ResponseEntity<>(rsp, HttpStatus.OK);
        } else {
            throw new BadRequestAlertException("Parameter is invalid", "transformServie", "nameExist");
        }
    }
}
