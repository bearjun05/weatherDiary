package my.weather;

import my.weather.domain.Memo;
import my.weather.repository.JdbcMemoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class JdbcMemoRepositoryTest {

    @Autowired
    JdbcMemoRepository jdbcMemoRepository;

    @Test
    void insertMemoTest() {

        //given
        Memo newMemo = new Memo(1, "this is new memo~");
        //when
        Memo me = jdbcMemoRepository.save(newMemo);
        //then
        Assertions.assertThat(me.getId()).isSameAs(1);
    }

    @Test
    void findAllMemoTest() {
        List<Memo> memoList = jdbcMemoRepository.findAll();
        System.out.println(memoList);
        Assertions.assertThat(memoList).isNotNull();
    }
}
