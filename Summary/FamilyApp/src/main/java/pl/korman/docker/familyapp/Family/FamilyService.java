package pl.korman.docker.familyapp.Family;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FamilyService {
    private FamilyRepo familyRepo;
}
