package my.weather;

import my.weather.domain.Memo;
import my.weather.repository.JpaMemoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional
public class JpaMemoRepositoryTest {

    @Autowired
    JpaMemoRepository jpaMemoRepository;

    @Test
    void insertMemoTest() {
        //given
        Memo memo = new Memo(1, "Hi");
        //when
        Memo save = jpaMemoRepository.save(memo);
        //then
        Assertions.assertThat(save.getText()).isSameAs("Hi");


    }
    @Test
    void findByIdTest() {
        //given
        Memo memo = new Memo(2, "jpa");
        //when
        Memo memo1 = jpaMemoRepository.save(memo);
        Optional<Memo> id = jpaMemoRepository.findById(memo1.getId());
        //then
        Assertions.assertThat(id.get().getText()).isSameAs("jpa");

    }




}
