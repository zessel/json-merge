
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cursor {

	@SerializedName("prev")
	@Expose
	private Object prev;
	@SerializedName("hasNext")
	@Expose
	private Boolean hasNext;
	@SerializedName("next")
	@Expose
	private String next;
	@SerializedName("hasPrev")
	@Expose
	private Boolean hasPrev;
	@SerializedName("total")
	@Expose
	private Object total;
	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("more")
	@Expose
	private Boolean more;

	public Object getPrev() {
		return prev;
	}

	public void setPrev(Object prev) {
		this.prev = prev;
	}

	public Boolean getHasNext() {
		return hasNext;
	}

	public void setHasNext(Boolean hasNext) {
		this.hasNext = hasNext;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public Boolean getHasPrev() {
		return hasPrev;
	}

	public void setHasPrev(Boolean hasPrev) {
		this.hasPrev = hasPrev;
	}

	public Object getTotal() {
		return total;
	}

	public void setTotal(Object total) {
		this.total = total;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getMore() {
		return more;
	}

	public void setMore(Boolean more) {
		this.more = more;
	}

}