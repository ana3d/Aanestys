package bean;

import java.text.DecimalFormat;

public class Vote {

	int id, vote_yes, vote_no, count;
	String subject, vote_yes_prcnt, vote_no_prcnt;
	DecimalFormat df = new DecimalFormat("0.00");

	public Vote(int id, int vote_yes, int vote_no, int count, String subject,
			String vote_yes_prcnt, String vote_no_prcnt) {
		super();
		this.id = id;
		this.vote_yes = vote_yes;
		this.vote_no = vote_no;
		this.count = count;
		this.subject = subject;
		this.vote_yes_prcnt = vote_yes_prcnt;
		this.vote_no_prcnt = vote_no_prcnt;
	}

	public Vote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVote_yes() {
		return vote_yes;
	}

	public void setVote_yes(int vote_yes) {
		this.vote_yes = vote_yes;
	}

	public int getVote_no() {
		return vote_no;
	}

	public void setVote_no(int vote_no) {
		this.vote_no = vote_no;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getVote_yes_prcnt() {

		int count = getCount();
		int yes_votes = getVote_yes();

		if (count == 0 || yes_votes == 0) {
			vote_yes_prcnt = "0";
		} else {
			double temp = (yes_votes * 100.0f) / count;
			vote_yes_prcnt = df.format(temp);
		}

		return vote_yes_prcnt;
	}

	public void setVote_yes_prcnt(String vote_yes_prcnt) {
		this.vote_yes_prcnt = vote_yes_prcnt;
	}

	public String getVote_no_prcnt() {

		int count = getCount();
		int no_votes = getVote_no();

		if (count == 0 || no_votes == 0) {
			vote_no_prcnt = "0";
		} else {
			double temp = (no_votes * 100.0f) / count;
			vote_no_prcnt = df.format(temp);
		}

		return vote_no_prcnt;
	}

	public void setVote_no_prcnt(String vote_no_prcnt) {
		this.vote_no_prcnt = vote_no_prcnt;
	}

	@Override
	public String toString() {
		return "Vote [id=" + id + ", vote_yes=" + vote_yes + ", vote_no="
				+ vote_no + ", count=" + count + ", subject=" + subject
				+ ", vote_yes_prcnt=" + vote_yes_prcnt + ", vote_no_prcnt="
				+ vote_no_prcnt + "]";
	}

}
