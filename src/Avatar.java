
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Avatar {

	@SerializedName("small")
	@Expose
	private Small small;
	@SerializedName("isCustom")
	@Expose
	private Boolean isCustom;
	@SerializedName("permalink")
	@Expose
	private String permalink;
	@SerializedName("cache")
	@Expose
	private String cache;
	@SerializedName("large")
	@Expose
	private Large large;

	public Small getSmall() {
		return small;
	}

	public void setSmall(Small small) {
		this.small = small;
	}

	public Boolean getIsCustom() {
		return isCustom;
	}

	public void setIsCustom(Boolean isCustom) {
		this.isCustom = isCustom;
	}

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

	public Large getLarge() {
		return large;
	}

	public void setLarge(Large large) {
		this.large = large;
	}

}