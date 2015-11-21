package team.hidro.highschoolsupport.entities;

import java.util.List;

public class InitialStatusDetail {
	List<StatusDetail> thongBaos;
	List<StatusDetail> hoiDaps;
	List<StatusDetail> taiLieus;
	public InitialStatusDetail(List<StatusDetail> thongBaos, List<StatusDetail> hoiDaps, List<StatusDetail> taiLieus) {
		super();
		this.thongBaos = thongBaos;
		this.hoiDaps = hoiDaps;
		this.taiLieus = taiLieus;
	}
	public List<StatusDetail> getThongBaos() {
		return thongBaos;
	}
	public void setThongBaos(List<StatusDetail> thongBaos) {
		this.thongBaos = thongBaos;
	}
	public List<StatusDetail> getHoiDaps() {
		return hoiDaps;
	}
	public void setHoiDaps(List<StatusDetail> hoiDaps) {
		this.hoiDaps = hoiDaps;
	}
	public List<StatusDetail> getTaiLieus() {
		return taiLieus;
	}
	public void setTaiLieus(List<StatusDetail> taiLieus) {
		this.taiLieus = taiLieus;
	}
	

}
