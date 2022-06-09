package pl.korman.docker.familyapp.Family;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class FamilyController {
    private FamilyService service;

}
