
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ObjectStructure {

	@SerializedName("cursor")
	@Expose
	private Cursor cursor;
	@SerializedName("code")
	@Expose
	private Integer code;
	@SerializedName("response")
	@Expose
	private List<Response> response = null;

	public Cursor getCursor() {
		return cursor;
	}

	public void setCursor(Cursor cursor) {
		this.cursor = cursor;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public List<Response> getResponse() {
		return response;
	}

	public void setResponse(List<Response> response) {
		this.response = response;
	}

}