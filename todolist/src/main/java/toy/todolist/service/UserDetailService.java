package toy.todolist.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.todolist.auth.UserDetail;
import toy.todolist.entity.User;
import toy.todolist.entity.dto.UserDto;
import toy.todolist.repository.UserRepository;

@Slf4j
@Transactional
@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void joinUser(UserDto user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println("user = " + user);
        User newUser = User.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .role("USER")
                .build();
        userRepository.save(newUser);
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        //여기서 받은 유저 패스워드와 비교하여 로그인 인증
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new UsernameNotFoundException(userId + " 유저가 존재하지 않습니다."));
        return new UserDetail(user);
    }
}
