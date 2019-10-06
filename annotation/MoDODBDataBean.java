package annotation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "mododb")
@XmlAccessorType(XmlAccessType.FIELD)
public class MoDODBDataBean {

	private String imsi;
	private String isdn;
	private String odbss;
	@Validator(allowedValues={"0", "1", "2", "NOBIC", "BAIC", "BICROAM"}, validate = true)
	private String odbic;
	@Validator(allowedValues={"0", "1", "2", "3", "4", "NOBOC", "BAOC", "BOIC", "BOICEXHC", "BOCROAM"}, validate = true)
	private String odboc;
	private String odbpb1;
	private String odbpb2;
	private String odbpb3;
	private String odbpb4;
	private String odbente;
	private String odbinfo;
	@Validator(allowedValues={"0", "1", "2", "3", "NOBAR", "BROHPLMN", "BROHPLMNC", "BROHPLMNCGPRS"}, validate = true)
	private String odbroam;
	private String odbrcf;
	private String odbect;
	private String odbdect;
	private String odbmect;
	@Validator(allowedValues={"0", "1", "2", "3", "NOBPOS", "BAPOS", "BHPLMNAPROAM", "BALLAPROAM"}, validate = true)
	private String odbpos;
	private String odbpostype;
	@Validator(nullcheck=true, minVal=1, maxVal= 255,  validate=true)
	private int hlrsn;
	
	private String odbente_roam;
	private String odbinfo_roam;
	
	private String impu;

	public String getOdbente_roam()
	{
		return odbente_roam;
	}

	public void setOdbente_roam(String odbente_roam)
	{
		this.odbente_roam = odbente_roam;
	}

	public String getOdbinfo_roam()
	{
		return odbinfo_roam;
	}

	public void setOdbinfo_roam(String odbinfo_roam)
	{
		this.odbinfo_roam = odbinfo_roam;
	}

	public String getImsi()
	{
		return imsi;
	}

	public void setImsi(String imsi)
	{
		this.imsi = imsi;
	}

	public String getIsdn()
	{
		return isdn;
	}

	public void setIsdn(String isdn)
	{
		this.isdn = isdn;
	}

	public String getOdbss()
	{
		return odbss;
	}

	public void setOdbss(String odbss)
	{
		this.odbss = odbss;
	}

	public String getOdbic()
	{
		return odbic;
	}

	public void setOdbic(String odbic)
	{
		this.odbic = odbic;
	}

	public String getOdboc()
	{
		return odboc;
	}

	public void setOdboc(String odboc)
	{
		this.odboc = odboc;
	}

	public String getOdbpb1()
	{
		return odbpb1;
	}

	public void setOdbpb1(String odbpb1)
	{
		this.odbpb1 = odbpb1;
	}

	public String getOdbpb2()
	{
		return odbpb2;
	}

	public void setOdbpb2(String odbpb2)
	{
		this.odbpb2 = odbpb2;
	}

	public String getOdbpb3()
	{
		return odbpb3;
	}

	public void setOdbpb3(String odbpb3)
	{
		this.odbpb3 = odbpb3;
	}

	public String getOdbpb4()
	{
		return odbpb4;
	}

	public void setOdbpb4(String odbpb4)
	{
		this.odbpb4 = odbpb4;
	}

	public String getOdbente()
	{
		return odbente;
	}

	public void setOdbente(String odbente)
	{
		this.odbente = odbente;
	}

	public String getOdbinfo()
	{
		return odbinfo;
	}

	public void setOdbinfo(String odbinfo)
	{
		this.odbinfo = odbinfo;
	}

	public String getOdbroam()
	{
		return odbroam;
	}

	public void setOdbroam(String odbroam)
	{
		this.odbroam = odbroam;
	}

	public String getOdbrcf()
	{
		return odbrcf;
	}

	public void setOdbrcf(String odbrcf)
	{
		this.odbrcf = odbrcf;
	}

	public String getOdbect()
	{
		return odbect;
	}

	public void setOdbect(String odbect)
	{
		this.odbect = odbect;
	}

	public String getOdbdect()
	{
		return odbdect;
	}

	public void setOdbdect(String odbdect)
	{
		this.odbdect = odbdect;
	}

	public String getOdbmect()
	{
		return odbmect;
	}

	public void setOdbmect(String odbmect)
	{
		this.odbmect = odbmect;
	}

	public String getOdbpos()
	{
		return odbpos;
	}

	public void setOdbpos(String odbpos)
	{
		this.odbpos = odbpos;
	}

	public String getOdbpostype()
	{
		return odbpostype;
	}

	public void setOdbpostype(String odbpostype)
	{
		this.odbpostype = odbpostype;
	}

	public String getImpu() {
		return impu;
	}

	public void setImpu(String impu) {
		this.impu = impu;
	}

	public int getHlrsn() {
		return hlrsn;
	}

	public void setHlrsn(int hlrsn) {
		this.hlrsn = hlrsn;
	}
	
	@Override
	public String toString() {
		return "MoDODBDataBean [imsi=" + imsi + ", isdn=" + isdn + ", odbss="
				+ odbss + ", odbic=" + odbic + ", odboc=" + odboc + ", odbpb1="
				+ odbpb1 + ", odbpb2=" + odbpb2 + ", odbpb3=" + odbpb3
				+ ", odbpb4=" + odbpb4 + ", odbente=" + odbente + ", odbinfo="
				+ odbinfo + ", odbroam=" + odbroam + ", odbrcf=" + odbrcf
				+ ", odbect=" + odbect + ", odbdect=" + odbdect + ", odbmect="
				+ odbmect + ", odbpos=" + odbpos + ", odbpostype=" + odbpostype
				+ ", hlrsn=" + hlrsn + ", odbente_roam=" + odbente_roam
				+ ", odbinfo_roam=" + odbinfo_roam + ", impu=" + impu + "]";
	}

}
