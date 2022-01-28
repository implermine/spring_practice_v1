package group_name.artifact_name;

import group_name.artifact_name.repository.JdbcMemberRepository;
import group_name.artifact_name.repository.JdbcTemplateMemberRepository;
import group_name.artifact_name.repository.MemberRepository;
import group_name.artifact_name.repository.MemoryMemberRepository;
import group_name.artifact_name.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memoryMemberRepository());
    }

    @Bean
    public MemberRepository memoryMemberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }

}
