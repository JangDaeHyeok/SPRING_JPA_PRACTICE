package com.jdh.jpaTest.test;

import com.jdh.jpaTest.model.entity.*;
import com.jdh.jpaTest.model.repository.ItemRepository;
import com.jdh.jpaTest.model.repository.MemberRepository;
import com.jdh.jpaTest.model.repository.ParentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@Slf4j
public class Model_4 {
    @Autowired ItemRepository itemRepository;
    @Autowired MemberRepository memberRepository;
    @Autowired ParentRepository parentRepository;

    @Test
    @DisplayName("아이템_SINGLE_TABLE_테스트")
    void 아이템_SINGLE_TABLE_테스트() {
        Album album = new Album();
        album.setName("테스트 앨범");
        album.setPrice(10000);
        album.setArtist("테스트 아티스트");
        album.setEtc("테스트 기타");
        itemRepository.save(album);
        assertThat(album.getArtist()).isEqualTo("테스트 아티스트");

        Book book = new Book();
        book.setName("테스트 책");
        book.setPrice(30000);
        book.setAuthor("테스트 지은이");
        book.setIsbn("테스트 isbn");
        itemRepository.save(book);
        assertThat(book.getAuthor()).isEqualTo("테스트 지은이");

        Movie movie = new Movie();
        movie.setName("테스트 영화");
        movie.setPrice(7000);
        movie.setDirector("테스트 감독");
        movie.setActor("테스트 배우");
        itemRepository.save(movie);
        assertThat(movie.getDirector()).isEqualTo("테스트 감독");
    }

    // 멤버 삽입, 수정 시 date 체크
    @Test
    void member_MappedSuperclass_test() throws InterruptedException {
        Member member = new Member();
        member.setName("장대혁");
        member = memberRepository.saveAndFlush(member);

        Thread.sleep(2000);

        member.setName("최미애");
        member = memberRepository.saveAndFlush(member);
    }

    // 복합키 테스트
    @Test
    void 복합키_테스트() {
        ParentId parentId = ParentId.builder()
                .id1("id1")
                .id2("id2")
                .build();

        Parent parent = Parent.builder()
                .id(parentId)
                .name("부모님 성함")
                .build();

        parentRepository.saveAndFlush(parent);
    }
}
