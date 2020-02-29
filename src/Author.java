import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Author {

	@SerializedName("username")
	@Expose
	private String username;
	@SerializedName("about")
	@Expose
	private String about;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("disable3rdPartyTrackers")
	@Expose
	private Boolean disable3rdPartyTrackers;
	@SerializedName("isPowerContributor")
	@Expose
	private Boolean isPowerContributor;
	@SerializedName("joinedAt")
	@Expose
	private String joinedAt;
	@SerializedName("profileUrl")
	@Expose
	private String profileUrl;
	@SerializedName("url")
	@Expose
	private String url;
	@SerializedName("location")
	@Expose
	private String location;
	@SerializedName("isPrivate")
	@Expose
	private Boolean isPrivate;
	@SerializedName("signedUrl")
	@Expose
	private String signedUrl;
	@SerializedName("isPrimary")
	@Expose
	private Boolean isPrimary;
	@SerializedName("isAnonymous")
	@Expose
	private Boolean isAnonymous;
	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("avatar")
	@Expose
	private Avatar avatar;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getDisable3rdPartyTrackers() {
		return disable3rdPartyTrackers;
	}

	public void setDisable3rdPartyTrackers(Boolean disable3rdPartyTrackers) {
		this.disable3rdPartyTrackers = disable3rdPartyTrackers;
	}

	public Boolean getIsPowerContributor() {
		return isPowerContributor;
	}

	public void setIsPowerContributor(Boolean isPowerContributor) {
		this.isPowerContributor = isPowerContributor;
	}

	public String getJoinedAt() {
		return joinedAt;
	}

	public void setJoinedAt(String joinedAt) {
		this.joinedAt = joinedAt;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Boolean getIsPrivate() {
		return isPrivate;
	}

	public void setIsPrivate(Boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public String getSignedUrl() {
		return signedUrl;
	}

	public void setSignedUrl(String signedUrl) {
		this.signedUrl = signedUrl;
	}

	public Boolean getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public Boolean getIsAnonymous() {
		return isAnonymous;
	}

	public void setIsAnonymous(Boolean isAnonymous) {
		this.isAnonymous = isAnonymous;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

}