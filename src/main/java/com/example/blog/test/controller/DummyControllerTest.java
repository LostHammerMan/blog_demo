package com.example.blog.test.controller;

import com.example.blog.entity.User;
import com.example.blog.model.role.RoleType;
import com.example.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

@RestController
@RequestMapping("/dummy")
public class DummyControllerTest {


    @Autowired // 의존성 주입
    private UserRepository userRepository;

    // http body에 username, password, email 데이터를 가지고 요청 -> 필드명과 변수명이 같으면 매핑됨
    // (@RequestParam 쓰지 않더라도)

    // 전체 조회
    @GetMapping("/users")
    public List<User> list(){
        return userRepository.findAll();
    }

    // 한 페이지당 2건에 데이터를 리턴, id 에 따른 정렬, 최신순
    @GetMapping("/user")
    public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        Page<User> pagingUser = userRepository.findAll(pageable);

       /* if (pagingUser.isFirst()){

        }*/
        List<User> users = pagingUser.getContent();

        return users;

    }

    // save 함수는 id 를 전달하지 않으면 insert, id를 전달하면 update
    // 단, id를 전달하면서 해당 id 에 대한 데이터가 없으면 insert

    // update
    // email, password
    @Transactional // 데이터에 변경이 있는 경우, DB 트랜잭션 실행 -> updateUser() 종료된후 자동종료 및 commit
    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User requestUser){ // json 요청 -> java object 로 변환해서 받아줌
        System.out.println("id = " + id);
        System.out.println("password = " + requestUser.getPassword());
        System.out.println("Email = " + requestUser.getEmail());

        // update - 방법 1
        User user = userRepository.findById(id).orElseThrow(() ->{
            return new IllegalArgumentException("수정실패 함");
        });

        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());


//        userRepository.save(user);

        // 방법 2 - @Transactional -> 더티 체킹 방법(변경 감지)

        return user;
    }

    // delete
    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable int id){
        try{
            userRepository.deleteById(id);
        } catch (Exception e){
            return "삭제 실패하였습니다. 해당 id는 DB에 없습니다";
        }

        return "삭제되었습니다 id = " + id;
    }

    @PostMapping("/join")
    public String join(User user){
        System.out.println("user = " + user.getId());
        System.out.println("username = " + user.getUsername());
        System.out.println("password = " + user.getPassword());
        System.out.println("email = " + user.getEmail());
        System.out.println("role = " + user.getRole());
        System.out.println("createDate = " + user.getCreateDate());

        user.setRole(RoleType.USER);
        userRepository.save(user);

        return "회원가입이 완료됨";
    }

    // {id} : 주소로 파라미터를 전달받을 수 있음

    @GetMapping("/user/{id}")
    public User detail(@PathVariable int id) {
        // user/4 를 찾을 때 DB 에서 못찾아오면 null 리턴됨
        // 따라서, Optional 로 user 객체를 감싸서 가져올테니 null 인지 확인 후 return
        /*User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
            @Override
            public User get() {
                return new User();
            }
        });*/

        /*User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 유저는 없습니다. id :" + id);
            }
        });*/

        // 람다식 표현(return 타입을 전혀 모르더라도 익명타입으로 사용 가능)
        User user = userRepository.findById(id).orElseThrow(() ->{
           return new IllegalArgumentException("해당 사용자는 없습니다 . id :" + id);
        });

        // 요청 : 웹브라우저
        // user 객체 = 자바 오브젝트
        // 변환 (웹브라우저가 이해할 수 있는 data) -> json
        // 스브링부트 : MessageConverter 가 응답시 자동 작동
        // 자바 오브젝트를 리턴하면 MessageConverter 가 Jackson 라이브러리를 호출해서
        // user 객체를 json 으로 변환해 브라우저에게 던저줌
        return user;

    }
}
