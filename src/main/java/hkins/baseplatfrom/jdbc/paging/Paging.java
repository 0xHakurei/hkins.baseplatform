package hkins.baseplatfrom.jdbc.paging;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Paging<T> {

    private int pageNumber;
    private int pageSize;
    private long pageCount;
    private long totalCount;
    private List<T> itemList;
    
    public int getPageNumber() {
        return pageNumber;
    }
    
    public int getPageSize() {
        return pageSize;
    }
    
    public long getPageCount() {
        return pageCount;
    }
    
    public long getTotalCount() {
        return totalCount;
    }
    
    public List<T> getItemList(){
        return this.itemList;
    }
    
    public Paging (int pageNumber, int pageSize, long totalCount, List<T> itemList) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.itemList = itemList;
        
        if(pageSize != 0) {
            if(totalCount % pageSize == 0L) {
                this.pageCount = (totalCount / pageSize);
            } else {
              this.pageCount = (totalCount / pageSize + 1);  
            }
        }
    }
    
    @JsonProperty("has_prev_page")
    public boolean hasPervPage() {
        return (this.pageNumber > 1) && (this.pageNumber <= this.pageCount);
    }
    
    @JsonProperty("has_next_page")
    public boolean hasNextPage() {
        return this.pageNumber < this.pageCount;
    }
    
    @JsonProperty("is_first_page")
    public boolean isFirstPage() {
        return this.pageNumber == 1;
    }
    
    @JsonProperty("is_last_page")
    public boolean isLastPage() {
        return this.pageNumber == this.pageCount;
    }
    
}
