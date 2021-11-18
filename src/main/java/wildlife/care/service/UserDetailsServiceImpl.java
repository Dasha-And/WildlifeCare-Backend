package wildlife.care.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import wildlife.care.model.UserDetailsImpl;
import wildlife.care.model.Worker;
import wildlife.care.repository.WorkerRepository;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    WorkerRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String id) {
        Optional<Worker> user = Optional.ofNullable(userRepository.findById(Integer.parseInt(id)));

        return user.map(UserDetailsImpl::new).get();
    }
}
