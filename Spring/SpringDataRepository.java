

import org.springframework.data.repository.PagingAndSortingRepository

public interface XXXRepository extends PagingAndSortingRepository<DocumentObject,String> {

   DocumentObject findBySignatureAndProductName(String signature, String ProductName);
   DocumentObject findByProductiD(String productId);
   
}

// The DocumentObject is the model object represent as the Document in the MongoDB

// -------------------------------------------------------------------------------------------------------- //

//The DocumentObject should be set as follows:
@TypeAlias("product")
@CompoundIndex(name = 'signature_1_productName_1', def="{'signature':1, 'productName':1}", unique = true, background = true)
@Document(collection = 'product')
public class Product {

    @Id
    String id;
    
    @Indexed(background = true)
    String productId;
    
    String subjectId;
    String productName;
}
