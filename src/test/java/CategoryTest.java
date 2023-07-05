import org.example.service.CategoryService;
import org.example.model.Category;
import org.example.util.UtilCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CategoryTest {

    private Category root;

    private CategoryService categoryService = new CategoryService();

    @BeforeEach
    public void init(){
        root = UtilCategory.populateCategory(0l, "root", true, 0l, Set.of("k1", "k2"));
        final Category category1 = UtilCategory.populateCategory(1l, "Home appliances", false, root.getLevel()+1, Set.of("k2", "k3") );
        final Category category2 = UtilCategory.populateCategory(2l, "Electronics", false, root.getLevel()+1, Set.of("k8", "k9"));
        root.addSubCategories(category1);
        root.addSubCategories(category2);

        final Category subCategoryHomeAppliances = UtilCategory.populateCategory(3l, "Major Appliances", false, category1.getLevel()+1, null );
        final Category subCategoryHomeAppliances2 = UtilCategory.populateCategory(4l, "Lawn Garden", false, category1.getLevel()+1, Set.of("Lawn", "Garden", "GardeningTools"));

        final Category subCategoryElectronics = UtilCategory.populateCategory(5l, "TV", false, category2.getLevel()+1, Set.of("Television", "Led") );
        final Category subCategoryElectronics2 = UtilCategory.populateCategory(6l, "CellPhone", false, category2.getLevel()+1, Set.of("Iphone", "Xiaomi", "phone"));

        final Category subPhone = UtilCategory.populateCategory(7l, "xiaomi 11 pro", false, subCategoryElectronics2.getLevel()+1, Set.of( "Xiaomi", "Note"));

        subCategoryElectronics2.addSubCategories(subPhone);

        category1.addSubCategories(subCategoryHomeAppliances);
        category1.addSubCategories(subCategoryHomeAppliances2);
        category2.addSubCategories(subCategoryElectronics);
        category2.addSubCategories(subCategoryElectronics2);
    }


    @Test
    public void getKeyWordCategory(){
        Set<String> categoryTest = categoryService.getKeywordByCategory(root, "CellPhone");
        assertTrue(categoryTest.contains("Iphone"));
        assertTrue(categoryTest.contains("Xiaomi"));
    }

    @Test
    public void getLevelCategory(){
        Long level = categoryService.getLevelByCategory(root, "Lawn Garden");
        assertEquals(2, level);
    }

}
