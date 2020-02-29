
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

	@SerializedName("editableUntil")
	@Expose
	private String editableUntil;
	@SerializedName("dislikes")
	@Expose
	private Integer dislikes;
	@SerializedName("numReports")
	@Expose
	private Integer numReports;
	@SerializedName("likes")
	@Expose
	private Integer likes;
	@SerializedName("message")
	@Expose
	private String message;
	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("createdAt")
	@Expose
	private String createdAt;
	@SerializedName("author")
	@Expose
	private Author author;
	@SerializedName("media")
	@Expose
	private List<Object> media = null;
	@SerializedName("isSpam")
	@Expose
	private Boolean isSpam;
	@SerializedName("isDeletedByAuthor")
	@Expose
	private Boolean isDeletedByAuthor;
	@SerializedName("isDeleted")
	@Expose
	private Boolean isDeleted;
	@SerializedName("parent")
	@Expose
	private Integer parent;
	@SerializedName("isApproved")
	@Expose
	private Boolean isApproved;
	@SerializedName("isFlagged")
	@Expose
	private Boolean isFlagged;
	@SerializedName("raw_message")
	@Expose
	private String rawMessage;
	@SerializedName("isHighlighted")
	@Expose
	private Boolean isHighlighted;
	@SerializedName("canVote")
	@Expose
	private Boolean canVote;
	@SerializedName("thread")
	@Expose
	private String thread;
	@SerializedName("forum")
	@Expose
	private String forum;
	@SerializedName("points")
	@Expose
	private Integer points;
	@SerializedName("moderationLabels")
	@Expose
	private List<Object> moderationLabels = null;
	@SerializedName("isEdited")
	@Expose
	private Boolean isEdited;
	@SerializedName("sb")
	@Expose
	private Boolean sb;

	public String getEditableUntil() {
		return editableUntil;
	}

	public void setEditableUntil(String editableUntil) {
		this.editableUntil = editableUntil;
	}

	public Integer getDislikes() {
		return dislikes;
	}

	public void setDislikes(Integer dislikes) {
		this.dislikes = dislikes;
	}

	public Integer getNumReports() {
		return numReports;
	}

	public void setNumReports(Integer numReports) {
		this.numReports = numReports;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Object> getMedia() {
		return media;
	}

	public void setMedia(List<Object> media) {
		this.media = media;
	}

	public Boolean getIsSpam() {
		return isSpam;
	}

	public void setIsSpam(Boolean isSpam) {
		this.isSpam = isSpam;
	}

	public Boolean getIsDeletedByAuthor() {
		return isDeletedByAuthor;
	}

	public void setIsDeletedByAuthor(Boolean isDeletedByAuthor) {
		this.isDeletedByAuthor = isDeletedByAuthor;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	public Boolean getIsFlagged() {
		return isFlagged;
	}

	public void setIsFlagged(Boolean isFlagged) {
		this.isFlagged = isFlagged;
	}

	public String getRawMessage() {
		return rawMessage;
	}

	public void setRawMessage(String rawMessage) {
		this.rawMessage = rawMessage;
	}

	public Boolean getIsHighlighted() {
		return isHighlighted;
	}

	public void setIsHighlighted(Boolean isHighlighted) {
		this.isHighlighted = isHighlighted;
	}

	public Boolean getCanVote() {
		return canVote;
	}

	public void setCanVote(Boolean canVote) {
		this.canVote = canVote;
	}

	public String getThread() {
		return thread;
	}

	public void setThread(String thread) {
		this.thread = thread;
	}

	public String getForum() {
		return forum;
	}

	public void setForum(String forum) {
		this.forum = forum;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public List<Object> getModerationLabels() {
		return moderationLabels;
	}

	public void setModerationLabels(List<Object> moderationLabels) {
		this.moderationLabels = moderationLabels;
	}

	public Boolean getIsEdited() {
		return isEdited;
	}

	public void setIsEdited(Boolean isEdited) {
		this.isEdited = isEdited;
	}

	public Boolean getSb() {
		return sb;
	}

	public void setSb(Boolean sb) {
		this.sb = sb;
	}
	
	@Override
	public int hashCode() {
	  return this.id.hashCode();
	}
	@Override
	public boolean equals(Object o) {
		return ((Response) o).getId() == this.getId();
	}
}