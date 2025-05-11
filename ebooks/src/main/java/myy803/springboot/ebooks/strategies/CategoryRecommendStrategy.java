package myy803.springboot.ebooks.strategies;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import myy803.springboot.ebooks.formsdata.RecommendFormData;
import myy803.springboot.ebooks.mappers.BookMapper;
import myy803.springboot.ebooks.models.Book;

public class CategoryRecommendStrategy extends TemplateRecommendStrategy{

	@Override
	public List<Book> makeInitialListOfBooks(RecommendFormData recomFormData, BookMapper bookMapper) {
		Set<Book> books = new HashSet<Book>();
		for (Book book: bookMapper.findAll()) {
			if (recomFormData.getFavoriteCategories().contains(book.getCategory().getName()))
				books.add(book);
		}
		
		return new ArrayList<>(books);
	}

}
