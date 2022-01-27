package group_name.artifact_name.repository;

import group_name.artifact_name.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();


    @AfterEach
    void tearDown() {
        repository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member();
        member.setName("Spring");

        //when
        repository.save(member);
        Member result = repository.findById(member.getId()).get();

        //then
        assertThat(result).isEqualTo(member);
    }

    @Test
    void findByName() {
        //given
        Member member1 = new Member();
        member1.setName("Spring1");

        Member member2 = new Member();
        member2.setName("Spring2");
        //when
        repository.save(member1);
        repository.save(member2);

        Member result = repository.findByName(member1.getName()).get();

        //then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("Spring1");

        Member member2 = new Member();
        member2.setName("Spring2");
        //when
        repository.save(member1);
        repository.save(member2);

        List<Member> result = repository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
    }
}