package com.bears.webPage.repos;

import com.bears.webPage.domain.Blocks;
import com.bears.webPage.domain.Other;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.attribute.standard.MediaSize;
import java.util.List;

public interface OtherRepo extends JpaRepository<Other,Integer> {
    Other findById(int id_other);
}
