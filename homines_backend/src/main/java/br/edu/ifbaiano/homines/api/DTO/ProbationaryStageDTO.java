package br.edu.ifbaiano.homines.api.DTO;

public class ProbationaryStageDTO {

	private String probationaryStageAvaliation;
	private String nextAvaliation;
	private int avaliation;
	private boolean situation;
	
	public String getProbationaryStageAvaliation() {
		return probationaryStageAvaliation;
	}
	public void setProbationaryStageAvaliation(String probationaryStageAvaliation) {
		this.probationaryStageAvaliation = probationaryStageAvaliation;
	}
	public String getNextAvaliation() {
		return nextAvaliation;
	}
	public void setNextAvaliation(String nextAvaliation) {
		this.nextAvaliation = nextAvaliation;
	}
	public int getAvaliation() {
		return avaliation;
	}
	public void setAvaliation(int avaliation) {
		this.avaliation = avaliation;
	}
	public boolean isSituation() {
		return situation;
	}
	public void setSituation(boolean situation) {
		this.situation = situation;
	}
	
}
