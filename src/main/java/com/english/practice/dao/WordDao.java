package com.english.practice.dao;

import com.english.practice.entity.Word;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WordDao {

	Word get(Integer id);

	int insert(Word word);

	int update(Word word);

	List<Word> queryWordsByType(@Param("classifyId") String classifyId,@Param("type") Integer type,
								@Param("page")Integer page,@Param("size")Integer size);

	Word queryWordByClassifyIdAndEnglish(@Param("englishWord")String englishWord,@Param("classifyId") String classifyId,
										 @Param("type") Integer type);

    Word edit(@Param("wordId") String wordId);

	int editIsStatusAndWordId(@Param("wordId")String wordId,@Param("isStatus") Integer isStatus);

    int editWord(Word word);

    Word queryEditWord(@Param("wordId")String wordId);

    long selectCount(@Param("classifyId")String classifyId);

    List<Word> PracticeEnglish(@Param("classifyId")String classifyId,@Param("sum") Integer sum);

	List<Word> PracticeChina(@Param("classifyId")String classifyId,@Param("sum") Integer sum);
}