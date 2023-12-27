package com.example.adoption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.adoption.entity.ForumEntrance;
import com.example.adoption.entity.NewInfo;
import com.example.adoption.entity.PostComment;
import com.example.adoption.entity.UserInfo;
import com.example.adoption.repository.UserInfoDao;
import com.example.adoption.service.ifs.ForumEntranceService;
import com.example.adoption.service.ifs.NewInfoService;
import com.example.adoption.service.ifs.PostCommentService;
import com.example.adoption.service.ifs.UserInfoService;
import com.example.adoption.vo.ForumEntranceReq;
import com.example.adoption.vo.ForumEntranceRes;
import com.example.adoption.vo.NewInfoRequest;
import com.example.adoption.vo.NewInfoResponse;
import com.example.adoption.vo.PostCommentReq;
import com.example.adoption.vo.PostCommentRes;
import com.example.adoption.vo.UserInfoRequest;
import com.example.adoption.vo.UserInfoResponse;

@SpringBootTest
class AdoptionApplicationTests {

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private UserInfoDao userInfoDao;

	@Autowired
	private NewInfoService newInfoService;

	@Autowired
	private ForumEntranceService forumEntranceService;

	@Autowired
	private PostCommentService postCommentService;

	@Test
	void PostCommentDeleteTest() {
		postCommentService.delete(3);
	}

	@Test
	void PostCommentUpdateTest() {
		PostComment postComment = new PostComment();
		postComment.setCommentId(3);
		postComment.setCommentContent("對阿對阿對阿~");
		PostCommentReq req = new PostCommentReq(postComment);
		postCommentService.update(req);
	}

	@Test
	void PostCommentSearchBySerialNoTest() {
		PostCommentRes res = postCommentService.searchByPostSerialNo(7);
		List<PostComment> postCommentList = res.getPostCommentList();
		for (PostComment postComment : postCommentList) {
			System.out.println(postComment.getUserName());
			System.out.println(postComment.getCommentContent());
		}
	}

	@Test
	void PostCommentCreateTest() {
		PostComment postComment = new PostComment();
		postComment.setPostSerialNo(7);
		postComment.setUserId(68);
		postComment.setUserName("怡君");
		postComment.setCommentContent("兔兔好可愛!!!");
		PostCommentReq req = new PostCommentReq(postComment);
		postCommentService.create(req);

	}

	@Test
	void ForumEntranceDeleteTest() {
		forumEntranceService.delete(5);
	}

	@Test
	void ForumEntranceUpdateTest() {
		ForumEntrance forumEntrance = new ForumEntrance();
		forumEntrance.setSerialNo(3);
		forumEntrance.setTitle("請問，我第一次養吉娃娃，我該注意什麼?(謝謝大家)");
		forumEntrance.setPostContent("謝謝大家，已經處理好了");
		ForumEntranceReq req = new ForumEntranceReq(forumEntrance);
		forumEntranceService.update(req);
	}

	@Test
	void ForumEntranceSearchTest() {
		ForumEntranceRes res = forumEntranceService.search();
		List<ForumEntrance> forumEntranceList = res.getForumEntranceList();
		for (ForumEntrance forumEntrance : forumEntranceList) {
			System.out.println(forumEntrance.getUserId());
			System.out.println(forumEntrance.getTitle());
			System.out.println(forumEntrance.getPostTime());
		}
	}

	@Test
	void ForumEntranceCreateTest() {
		ForumEntrance forumEntrance = new ForumEntrance();
		forumEntrance.setUserId(66);
		forumEntrance.setTitle("求助，我家的貓咪突然吃不下飯，線上等，急!!");
		forumEntrance.setPostContent("貓咪從昨天突然就沒有睡覺，然後也吃不太下，我應該帶去看醫生嗎?");
		ForumEntranceReq req = new ForumEntranceReq(forumEntrance);
		forumEntranceService.create(req);
	}

	@Test
	void userInfoCreateTest() {
		UserInfo userInfo = new UserInfo();
		LocalDate birth = LocalDate.parse("1995-03-13");

		userInfo.setUserName("玉翔");
		userInfo.setPassword("Az123456");
		userInfo.setEmail("iql2010317@gmail.com");
		userInfo.setBirthday(birth);

		UserInfoRequest req = new UserInfoRequest(userInfo);
		userInfoService.create(req);

	}

	@Test
	void createFakeUserTest() {
		UserInfo userInfo = new UserInfo();
		LocalDate birth = LocalDate.parse("1978-05-15");

		userInfo.setUserName("早餐店阿姨");
		userInfo.setPassword("Az123456");
		userInfo.setEmail("test01@gmail.com");
		userInfo.setBirthday(birth);

		UserInfoRequest req = new UserInfoRequest(userInfo);
		userInfoService.createFakeUser(req);
	}

	@Test
	void userInfoUpdateTest() {
		// 嚙踝蕭嚙踝蕭嚙緩嚙編嚙箭嚙踝蕭嚙複庫嚙踝蕭嚙踝蕭 UserInfo
		int userIdToUpdate = 13; // 嚙踝蕭嚙稽嚙豎要嚙踝蕭s嚙踝蕭嚙諄歹蕭ID嚙踝蕭1
		UserInfo existingUserInfo = userInfoDao.findById(userIdToUpdate).orElse(null);

		// 嚙踝蕭嚙稽嚙箭嚙踝蕭w嚙踝蕭嚙踝蕭嚙瘤嚙諉用歹蕭H嚙踝蕭
		assertNotNull(existingUserInfo);

		// 嚙踝蕭s嚙諉使用者迎蕭嚙踝蕭嚙�
		existingUserInfo.setUserName("嚙踝蕭"); // 嚙踝蕭s嚙諄歹蕭W嚙踝

		// 嚙請建一嚙踝蕭 UserInfoRequest 嚙踝蕭嚙踝蕭
		UserInfoRequest req = new UserInfoRequest(existingUserInfo);

		// 嚙瘢嚙編 update 嚙踝蕭k嚙箠嚙踝蕭嚙編
		UserInfoResponse response = userInfoService.update(req);

		// 嚙確嚙緹嚙踝蕭s嚙賦的嚙稷嚙踝蕭嚙瞌嚙稻嚙踝蕭嚙穀
		assertNotNull(response);
		assertEquals(existingUserInfo.getUserName(), response.getUserInfo().getUserName());
	}

	// 嚙瞎嚙踝蕭H嚙踝蕭嚙踝蕭M嚙踝蕭
	@Test
	void userInfoSearchTest() {
		UserInfoResponse res = userInfoService.search();
		List<UserInfo> userInfoList = res.getUserInfoList();
		for (UserInfo userInfo : userInfoList) {
			System.out.println("嚙瘡嚙踝蕭嚙磕嚙踝蕭:" + userInfo.getUserName());
			System.out.println("嚙緬嚙締嚙締嚙踝蕭:" + userInfo.getEmail());
			System.out.println("嚙踝蕭嚙踝蕭嚙踝蕭X:" + userInfo.getPhone());
		}
	}

	@Test
	void userInfoLoginTest() {
		String validEmail = "iql2010317@gmail.com";
		String validPassword = "Az123456";

		String loginResult = userInfoService.userLogin(validEmail, validPassword);

		System.out.println(loginResult);
	}

	@Test
	void userForgetPassWordTest() {
		String validEmail = "iql2010317@gmail.com";

		String loginResult = userInfoService.userFogetPassword(validEmail);

		System.out.println(loginResult);
	}

	@Test
	void forceChangePasswordTest() {
		String validEmail = "iql2010317@gmail.com";
		String newPwd = "Az654321";
		String conPwd = "Az654321";

		String loginResult = userInfoService.forceChangePassword(validEmail, newPwd, conPwd);

		System.out.println(loginResult);

	}

	@Test
	void searchTest() {
		UserInfoResponse res = userInfoService.searchById(53);
		UserInfo user = res.getUserInfo();
		System.out.println(user.getAccount());
	}

	@Test
	void newInfoTest() {
		LocalDate date = LocalDate.parse("2023-03-15");
		NewInfo newInfo = new NewInfo();
		newInfo.setTitle("【巴克預備學校 體驗營】即刻報名！");
		newInfo.setContent("巴克預備學校 小小訓犬師體驗營\r\n" + "<點此報名>\r\n" + "\r\n" + "\r\n" + "想要幫助浪浪嗎？\r\n" + "\r\n"
				+ "讓我們陪伴孩子，成為「小小訓練師」，學習浪浪相關知識，協助他們找到最適合的家人吧！\r\n"
				+ "參與巴克幫獨創的送養系統-「巴克預備學校」的四步驟過程，讓小朋友知道狗狗也需要學習，經過社會化之後，可以更快融入家庭生活；同時了解台灣流浪狗的處境，學習正確跟狗狗相處方式。\r\n" + "\r\n"
				+ "和巴克幫一起，讓浪浪們知道：「沒關係，有我在」。");
		newInfo.setDate(date);
		newInfo.setCategory("活動");
		NewInfoRequest req = new NewInfoRequest(newInfo);
		newInfoService.create(req);
	}

	@Test
	void NewsearchTest() {
		NewInfoResponse res = newInfoService.search();
		List<NewInfo> newInfoList = res.getNewInfoList();
		for (NewInfo newInfo : newInfoList) {
			System.out.println(newInfo.getTitle());
			System.out.println(newInfo.getDate());
			System.out.println("=========");
		}
	}

}
