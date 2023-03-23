package backend.spring.enduser;

import backend.spring.enduser.Enduser;
import backend.spring.enduser.EnduserDTO;
import backend.spring.enduser.EnduserRepository;
import backend.spring.exeptions.UserDoesntExistException;
import backend.spring.exeptions.UserIsNotAdminException;
import backend.spring.security.DAO.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

    private final EnduserRepository enduserRepository;

    @Override
    public List<EnduserDTO> getAllUsers(String username) throws UserDoesntExistException, UserIsNotAdminException {
        Enduser enduser = enduserRepository.findByUsername(username)
                .orElseThrow(() -> new UserDoesntExistException ("User not found"));

        if (enduser.getRole() != Role.ADMIN) {
            throw new UserIsNotAdminException("User is not an admin");
        }

        List<Enduser> endusers = enduserRepository.findAll();
        List<EnduserDTO> enduserDTOs = endusers.stream()
                .map(EnduserDTO::new)
                .collect(Collectors.toList());

        return enduserDTOs;
    }

}
