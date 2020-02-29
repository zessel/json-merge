
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Small {

	@SerializedName("permalink")
	@Expose
	private String permalink;
	@SerializedName("cache")
	@Expose
	private String cache;

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	public String getCache() {
		return cache;
	}

	public void setCache(String cache) {
		this.cache = cache;
	}
}