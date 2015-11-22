package team.hidro.highschoolsupport.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import team.hidro.highschoolsupport.entities.ListClassDetail;
import team.hidro.highschoolsupport.entities.ScoreDetail;
import team.hidro.highschoolsupport.entities.StudentScoreDetail;
import team.hidro.highschoolsupport.entities.TeacherDetail;
import team.hidro.highschoolsupport.service.ClassService;
import team.hidro.highschoolsupport.service.ScoreService;
import team.hidro.highschoolsupport.service.TeacherService;

@Controller
public class ScoreController {

	@Autowired
	private TeacherService teacherService;
	@Autowired
	private ClassService classService;
	@Autowired
	private ScoreService scoreService;
	
	public @ResponseBody boolean createScore(@PathVariable("score") int score, @PathVariable("subjectYearId") int subjectYearId,
			@PathVariable("type") int type, @PathVariable("userId") int userId,  @PathVariable("ky") int ky) {
		
		ScoreDetail scoreDetail = new ScoreDetail(score, type, userId, subjectYearId, ky);
		return scoreService.save(scoreDetail);
	}
	
	@RequestMapping("/class/{idClass}/student/{subjectId}")
	public @ResponseBody List<StudentScoreDetail> _getClass(@PathVariable("idClass") int idClass, @PathVariable("subjectId") int idSubject){
		return classService.getListStudentScoreByClassAndSubject(idClass, idSubject, 1);
	}
	
	@RequestMapping("/class")
	public @ResponseBody List<ListClassDetail> classTeacher(HttpSession session){
		
		TeacherDetail teacher = (TeacherDetail) session.getAttribute("user");
		return teacherService.getListClassByTeacherId(teacher.getUserId());
		
	}
	
	@RequestMapping("/avg_grade")
	public ModelAndView getAVGGrade(){
		return new ModelAndView("avg_grade");
	}
	
	@RequestMapping(value = "class/update_score", method = RequestMethod.POST)
	public  @ResponseBody void updateScore(@RequestParam Map<String,String> params){
		String content =params.toString();
		JSONObject obj = new JSONObject(content.substring(1,content.length()-2));
		
		List<ScoreDetail> scoreDetails = new ArrayList<ScoreDetail>();
		JSONArray array = obj.getJSONArray("scores");
		for(int i = 0 ; i < array.length() ; i++){
		    int id =array.getJSONObject(i).getInt("id");
		    String scoreString =array.getJSONObject(i).get("score")+"";
		    int type =array.getJSONObject(i).getInt("type");
		    int userId =array.getJSONObject(i).getInt("userId");
		    int subjectYearId =array.getJSONObject(i).getInt("subjectYearId");
		    int ky =array.getJSONObject(i).getInt("ky");
		    int score= scoreString.equals("") ? -1: Integer.parseInt(scoreString);
		    ScoreDetail scoreDetail = new ScoreDetail(id,score, type, userId, subjectYearId, ky);
		    scoreDetails.add(scoreDetail);
		}
		
		for (ScoreDetail scoreDetail : scoreDetails) {
			if(scoreDetail.getScore()==-1&&scoreDetail.getId()!=0)
				scoreService.remove(scoreDetail.getId());
			if(scoreDetail.getScore()!=-1&&scoreDetail.getId()!=0)
				scoreService.update(scoreDetail);
			if(scoreDetail.getScore()!=-1&&scoreDetail.getId()==0)
				scoreService.save(scoreDetail);
		}
		
	}
}
