package com._root.init;

/*  
    程式說明：建立表格與設定初始測試資料。
    表格包括：Book, BookCompany, Member, Orders, OrderItems
 
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Blob;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.a.model.GenreBean;
import com.a.model.MovieBean;
import com.a.model.MovieRatingBean;
import com.a.model.MovieStatusBean;
import com.a.model.RunningBean;
import com.a.model.RunningStatusBean;
import com.a.model.SCOrderDetailBean;
import com.a.model.SCOrdersBean;
import com.a.model.ShippingStatusBean;
import com.a.model.ShowTimeHistoryBean;
import com.c.model.HallBean;
import com.c.model.HallStatusBean;
import com.c.model.ReservationStatusBean;
import com.c.model.SeatStatusBean;
import com.c.model.SeatsBean;
import com.c.model.TypeOfSeatBean;
import com.l.model.CategoriesBean;
import com.l.model.MOrderBean;
import com.l.model.MOrderDetailBean;
import com.l.model.ProductsBean;
import com.l.model.TicketBean;
import com.p.model.HallOrderBean;
import com.p.model.HallOrderStatusBean;
import com.p.model.MemberBean;
import com.p.model.PayStatusBean;
import com.t.model.CommentBean;
import com.t.model.ExpectationBean;
import com.t.model.PreferenceBean;
import com.z.model.AnnoBean;
import com.z.model.AnnoStatusBean;
import com.z.model.EmpBean;
import com.z.model.EmpStatusBean;
import com.z.model.QuestionBean;
import com.z.model.QuestionContentBean;
import com.z.model.QuestionStatusBean;
import com.z.model.RoleBean;

public class EDMTableResetHibernate {
	public static final String UTF8_BOM = "\uFEFF"; // 定義 UTF-8的BOM字元

	/**
	 * @param args
	 */
	public static void main(String args[]) {

		String line = "";

		int count = 0;
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			try (FileReader fr = new FileReader("data/RoleBean.dat"); BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					String name = token[0];
					RoleBean rb = new RoleBean(name);
					session.save(rb);
				}
			} catch (IOException e) {
				System.err.println("新建RoleBean表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("RoleBean 資料新增成功");

			try (FileReader fr = new FileReader("data/EmpStatus.dat"); BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					String name = token[0];
					EmpStatusBean esb = new EmpStatusBean(name);
					session.save(esb);
				}
			} catch (IOException e) {
				System.err.println("新建EmpStatusBean表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("EmpStatusBean 資料新增成功");

			try (FileReader fr = new FileReader("data/emp.dat"); BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					EmpBean eb = new EmpBean();

					eb.setEmpName(token[0]);
					Integer roleId = Integer.parseInt(token[1]);
					RoleBean RoleBean = session.get(RoleBean.class, roleId);
					eb.setRoleBean(RoleBean);
					eb.setEmail(token[2]);
					eb.setPassword(token[3]);
					Integer status = Integer.parseInt(token[4]);
					EmpStatusBean esb = session.get(EmpStatusBean.class, status);
					eb.setEmpStatusBean(esb);
					eb.setStartDate(token[5]);
					eb.setEndDate(token[6]);
					eb.setUid(token[7]);

					session.save(eb);
				}
			} catch (IOException e) {
				System.err.println("新建Emp表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("Emp資料新增成功");

			try (FileReader fr = new FileReader("data/annoStatus.dat"); BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					String name = token[0];
					AnnoStatusBean asb = new AnnoStatusBean(name);
					session.save(asb);
				}
			} catch (IOException e) {
				System.err.println("新建AnnoStatus表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("AnnoStatus 資料新增成功");
			
			
//questionStatus
			try (FileReader fr = new FileReader("data/quesStatus.dat"); BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					String name = token[0];
					QuestionStatusBean asb = new QuestionStatusBean(name);
					session.save(asb);
				}
			} catch (IOException e) {
				System.err.println("新建QuesStatus表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("QuestionStatus 資料新增成功");
			
			

			// 以下為公告灌資料
			try (FileReader fr = new FileReader("data/anno.dat"); BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					AnnoBean ab = new AnnoBean();

					ab.setTitle(token[0]);
					ab.setContent(token[1]);
					ab.setPriority(Integer.parseInt(token[2]));
					Integer status = Integer.parseInt(token[3]);
					AnnoStatusBean asb = session.get(AnnoStatusBean.class, status);
					ab.setAnnoStatusBean(asb);
					ab.setStartTime(token[4]);
					ab.setEndTime(token[5]);

					session.save(ab);
				}
			} catch (IOException e) {
				System.err.println("新建Anno表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("Anno資料新增成功");

//這邊開始ReservationStatusBean	
			try (FileReader fr = new FileReader("data/reservationStatus.dat");
					BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					ReservationStatusBean cb = new ReservationStatusBean();

					cb.setReservationStatusID(Integer.parseInt(token[0]));
					cb.setReservationStatusName(token[1]);

					session.save(cb);
				}
			} catch (IOException e) {
				System.err.println("新建ReservationStatusBean表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("ReservationStatusBean資料新增成功");
//CategoriesBean	
			try (FileReader fr = new FileReader("data/Categories.dat"); BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					CategoriesBean cb = new CategoriesBean();

					cb.setCategoryName(token[0]);

					session.save(cb);
				}
			} catch (IOException e) {
				System.err.println("新建Categories表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("Categories資料新增成功");
//ProductsBean	
			try (FileReader fr = new FileReader("data/Products.dat"); BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					ProductsBean cb = new ProductsBean();

					cb.setProductName(token[0]);
					CategoriesBean CategoriesBean = session.get(CategoriesBean.class, Integer.parseInt(token[1]));
					cb.setCategoriesBean(CategoriesBean);
					cb.setUnitPrice(Integer.parseInt(token[2]));
					cb.setUnitStock(Integer.parseInt(token[3]));
					cb.setCost(Integer.parseInt(token[4]));
					if(!token[5].equalsIgnoreCase("NULL")) {
						Blob blob = SystemUtils2018.fileToBlob(token[5].trim());
						cb.setProductImage(blob);
						cb.setFileName(SystemUtils2018.extractFileName(token[5].trim()));
					}else {
						// 先null因為還沒放照片的假資料
						cb.setProductImage(null);
					}
					cb.setProductDescription(token[6]);
					session.save(cb);
				}
			} catch (IOException e) {
				System.err.println("新建ProductsBean表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("ProductsBean資料新增成功");
//GenreBean
			try (FileReader fr = new FileReader("data/genre.dat"); BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					GenreBean eb = new GenreBean();

					eb.setGenreID(Integer.parseInt(token[0]));
					eb.setGenre(token[1]);

					session.save(eb);
				}
			} catch (IOException e) {
				System.err.println("新建Genre表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("Genre資料新增成功");
//PayStatusBean
			try (FileReader fr = new FileReader("data/payStatus.dat"); BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					PayStatusBean eb = new PayStatusBean();

					eb.setPayStatusNO(Integer.parseInt(token[0]));
					eb.setPayStatus(token[1]);

					session.save(eb);
				}
			} catch (IOException e) {
				System.err.println("新建PayStatusBean表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("PayStatusBean資料新增成功");
//HallStatusBean
			try (FileReader fr = new FileReader("data/hallStatus.dat"); BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					HallStatusBean eb = new HallStatusBean();

					eb.setHallStatusID(Integer.parseInt(token[0]));
					eb.setHallStatusName(token[1]);

					session.save(eb);
				}
			} catch (IOException e) {
				System.err.println("新建HallStatusBean表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("HallStatusBean資料新增成功");
//HallOrderStatusBean
			try (FileReader fr = new FileReader("data/hallOrderStatus.dat");
					BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					HallOrderStatusBean eb = new HallOrderStatusBean();

					eb.setHallOrderStatusNo(Integer.parseInt(token[0]));
					eb.setHallOrderStatus(token[1]);

					session.save(eb);
				}
			} catch (IOException e) {
				System.err.println("新建HallOrderStatusBean表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("HallOrderStatusBean資料新增成功");
//HallBean
			try (FileReader fr = new FileReader("data/hall.dat"); BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					HallBean eb = new HallBean();

					eb.setHallID(token[0]);
					eb.setColNum(Integer.parseInt(token[1]));
					eb.setNoOfSeats(Integer.parseInt(token[2]));
					eb.setPrice(Integer.parseInt(token[3]));
					eb.setRowNum(Integer.parseInt(token[4]));
					Integer hallStatus = Integer.parseInt(token[5]);
					HallStatusBean HallStatusBean = session.get(HallStatusBean.class, hallStatus);
					eb.setHallStatusBean(HallStatusBean);

					session.save(eb);
				}
			} catch (IOException e) {
				System.err.println("新建HallBean表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("HallBean資料新增成功");
//MovieRatingBean
			try (FileReader fr = new FileReader("data/MovieRating.dat"); BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					MovieRatingBean eb = new MovieRatingBean();
					eb.setMovieRatingID(Integer.parseInt(token[0]));
					eb.setAge(Integer.parseInt(token[1]));
					eb.setrating(token[2]);

					session.save(eb);
				}
			} catch (IOException e) {
				System.err.println("新建MovieRatingBean表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("MovieRatingBean資料新增成功");
//MemberBean
			try (FileReader fr = new FileReader("data/Member.dat"); BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					MemberBean eb = new MemberBean();

					eb.setAccount(token[0]);
					eb.setAddress(token[1]);
					eb.setBirth(token[2]);
					eb.setEmail(token[3]);
					eb.setGender(token[4]);
					eb.setLastLogInTime(token[5]);
					eb.setMobile(token[6]);
					eb.setName(token[7]);
					eb.setPassword(token[8]);
					eb.setRegisterTime(token[9]);
					eb.setuID(token[10]);
					eb.setCheckPassword(token[11]);

					session.save(eb);
				}
			} catch (IOException e) {
				System.err.println("新建MemberBean表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("MemberBean資料新增成功");
//HallOrderBean
			try (FileReader fr = new FileReader("data/hallOrder.dat"); BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					HallOrderBean eb = new HallOrderBean();

					eb.setContactPerson(token[0]);
					eb.setEndTime(token[1]);
					eb.setHallPurpose(token[2]);
					eb.setHallPurposeDetail(token[3]);
					eb.setHallSubtotal(Integer.parseInt(token[4]));
					eb.setMail(token[5]);
					eb.setMobile(token[6]);
					eb.setOrderDate(token[7]);
					eb.setOrderHours(Integer.parseInt(token[8]));
					eb.setStartTime(token[9]);
					HallBean HallBean = session.get(HallBean.class, token[10]);
					eb.setHb(HallBean);
					Integer hallOrderStatusNo = Integer.parseInt(token[11]);
					HallOrderStatusBean HallOrderStatusBean = session.get(HallOrderStatusBean.class, hallOrderStatusNo);
					eb.setHob(HallOrderStatusBean);
					Integer memberId = Integer.parseInt(token[12]);
					MemberBean MemberBean = session.get(MemberBean.class, memberId);
					eb.setMb(MemberBean);
					Integer payStatusNo = Integer.parseInt(token[13]);
					PayStatusBean PayStatusBean = session.get(PayStatusBean.class, payStatusNo);
					eb.setPsb(PayStatusBean);

					session.save(eb);
				}
			} catch (IOException e) {
				System.err.println("新建HallOrderBean表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("HallOrderBean資料新增成功");

//SeatStatusBean
			try (FileReader fr = new FileReader("data/seatStatus.dat"); BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					SeatStatusBean eb = new SeatStatusBean();

					eb.setSeatStatusID(Integer.parseInt(token[0]));
					eb.setSeatStatusName(token[1]);

					session.save(eb);
				}
			} catch (IOException e) {
				System.err.println("新建SeatStatusBean表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("SeatStatusBean資料新增成功");

//TypeOfSeatBean
			try (FileReader fr = new FileReader("data/typeofSeat.dat"); BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					TypeOfSeatBean eb = new TypeOfSeatBean();

					eb.setTypeofSeatID(Integer.parseInt(token[0]));
					eb.setTypeofSeatName(token[1]);

					session.save(eb);
				}
			} catch (IOException e) {
				System.err.println("新建TypeOfSeatBean表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("TypeOfSeatBean資料新增成功");
//SeatsBean
			try (FileReader fr = new FileReader("data/seats.dat"); BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					SeatsBean eb = new SeatsBean();

					eb.setSeatID(token[0]);
					eb.setRow(token[1]);
					eb.setSeatNo(Integer.parseInt(token[2]));
					HallBean HallBean = session.get(HallBean.class, token[3]);
					eb.setHallBean(HallBean);
					Integer seatStatus = Integer.parseInt(token[4]);
					SeatStatusBean SeatStatusBean = session.get(SeatStatusBean.class, seatStatus);
					eb.setSeatStatusBean(SeatStatusBean);
					Integer typeOfSeat = Integer.parseInt(token[5]);
					TypeOfSeatBean TypeOfSeatBean = session.get(TypeOfSeatBean.class, typeOfSeat);
					eb.setTypeOfSeatBean(TypeOfSeatBean);

					session.save(eb);
				}
			} catch (IOException e) {
				System.err.println("新建seats表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("seats資料新增成功");
//MovieStatusBean
			try (FileReader fr = new FileReader("data/movieStatus.dat"); BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					MovieStatusBean msb = new MovieStatusBean();
					msb.setStatusID(Integer.parseInt(token[0]));
					msb.setStatus(token[1]);
					session.save(msb);

				}
			} catch (IOException e) {
				System.err.println("新建MovieStatus表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("MovieStatus資料新增成功");

//MovieBean
			try (FileReader fr = new FileReader("data/movie.dat"); BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					MovieBean mb = new MovieBean();
					mb.setMovieID(Integer.parseInt(token[0]));
					mb.setCast(token[1]);
					mb.setContractDate(token[2]);
					mb.setDirector(token[3]);
					mb.setExpectedProfit(Integer.parseInt(token[4]));
					//若有圖就放
					if(!token[5].equalsIgnoreCase("NULL")) {
						Blob blob = SystemUtils2018.fileToBlob(token[5].trim());
						mb.setPhoto(blob);
						mb.setFileName(SystemUtils2018.extractFileName(token[5].trim()));
					}else {
						// 先null因為還沒放照片的假資料
						mb.setPhoto(null);
					}
					mb.setPlotSummary(token[6]);
					mb.setProfitRatio(Double.parseDouble(token[7]));
					mb.setRunningTime(Integer.parseInt(token[8]));
					mb.setTitle(token[9]);
					mb.setTrailer(token[10]);
					GenreBean gb = session.get(GenreBean.class, Integer.parseInt(token[11]));
					mb.setGenreBean(gb);
					MovieRatingBean mrb = session.get(MovieRatingBean.class, Integer.parseInt(token[12]));
					mb.setMovieRatingBean(mrb);
					MovieStatusBean msb = session.get(MovieStatusBean.class, Integer.parseInt(token[13]));
					mb.setMovieStatusBean(msb);
					session.save(mb);
				}
			} catch (IOException e) {
				System.err.println("新建Movie表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("Movie資料新增成功");
//RunningStatusBean
			try (FileReader fr = new FileReader("data/runningStatus.dat");
					BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					RunningStatusBean rsb = new RunningStatusBean();

					rsb.setStatusID(Integer.parseInt(token[0]));
					rsb.setStatus(token[1]);

					session.save(rsb);
				}
			} catch (IOException e) {
				System.err.println("新建RunningStatus表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("RunningStatus資料新增成功");

//RunningBean
			try (FileReader fr = new FileReader("data/running.dat"); BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					RunningBean rb = new RunningBean();

					rb.setRunID(Integer.parseInt(token[0]));
					rb.setExpectedOffDate(token[1]);
					rb.setExpectedOnDate(Integer.parseInt(token[2]));
					rb.setOffDate(token[3]);
					rb.setOnDate(Integer.parseInt(token[4]));
					rb.setRelease(token[5]);
					MovieBean mb = session.get(MovieBean.class, Integer.parseInt(token[6]));
					rb.setMovie(mb);
					RunningStatusBean rsb = session.get(RunningStatusBean.class, Integer.parseInt(token[7]));
					rb.setRunningStatus(rsb);

					session.save(rb);
				}
			} catch (IOException e) {
				System.err.println("新建Running表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("Running資料新增成功");
//ShowTimeHistoryBean
			try (FileReader fr = new FileReader("data/ShowTimeHistory.dat");
					BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					ShowTimeHistoryBean sthb = new ShowTimeHistoryBean();

					sthb.setShowTimeId(Integer.parseInt(token[0]));
					sthb.setPlayStartTime(token[1]);
					HallBean hb = session.get(HallBean.class, token[2]);
					sthb.setHall(hb);
					RunningBean rb = session.get(RunningBean.class, Integer.parseInt(token[3]));
					sthb.setRun(rb);

					session.save(sthb);
				}
			} catch (IOException e) {
				System.err.println("新建ShowTimeHistory表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("ShowTimeHistory資料新增成功");
//ShippingStatusBean
			try (FileReader fr = new FileReader("data/shippingStatus.dat");
					BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					ShippingStatusBean ssb = new ShippingStatusBean();

					ssb.setShippingStatusID(Integer.parseInt(token[0]));
					ssb.setShippingStatus(token[1]);

					session.save(ssb);
				}
			} catch (IOException e) {
				System.err.println("新建ShippingStatus表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("ShippingStatus資料新增成功");
//MOrderBean	
			try (FileReader fr = new FileReader("data/mOrder.dat"); BufferedReader br = new BufferedReader(fr);) {
			    while ((line = br.readLine()) != null) {
			     if (line.startsWith(UTF8_BOM)) {
			      line = line.substring(1);
			     }
			     String[] token = line.split("\\|");
			     MOrderBean mob = new MOrderBean();
			     
			     mob.setTicketStatus(Integer.parseInt(token[0]));
			     mob.setOrderTime(token[1]);
			     ShowTimeHistoryBean sthb = session.get(ShowTimeHistoryBean.class, Integer.parseInt(token[2]));
			     mob.setShowTimeHistoryBean(sthb);
			     MemberBean mb = session.get(MemberBean.class, Integer.parseInt(token[3]));
			     mob.setMemberBean(mb);
			     mob.setTicketTime(token[4]);
			     EmpBean eb = session.get(EmpBean.class, Integer.parseInt(token[5]));
			     mob.setEmpBean(eb);
			     session.save(mob);
			    }
			   } catch (IOException e) {
			    System.err.println("新建MOrderBean表格時發生IO例外: " + e.getMessage());
			   }
			   session.flush();
			   System.out.println("MOrderBean資料新增成功");  

//MOrderDetailBean	
				try (FileReader fr = new FileReader("data/mOrderDetail.dat"); BufferedReader br = new BufferedReader(fr);) {
				    while ((line = br.readLine()) != null) {
				     if (line.startsWith(UTF8_BOM)) {
				      line = line.substring(1);
				     }
				     String[] token = line.split("\\|");
				     MOrderDetailBean modb = new MOrderDetailBean();
				    
				     MOrderBean mb = session.get(MOrderBean.class, Integer.parseInt(token[0]));
				     modb.setmOrderBean(mb);
				     ProductsBean pb = session.get(ProductsBean.class, Integer.parseInt(token[1]));
				     modb.setProductsBean(pb);
				     modb.setSellUnitPrice(Integer.parseInt(token[2]));
				     modb.setDiscount(Double.parseDouble(token[3]));
				     modb.setQuantity(Integer.parseInt(token[4]));
				     session.save(modb);
				    }
				   } catch (IOException e) {
				    System.err.println("新建MOrderDetailBean表格時發生IO例外: " + e.getMessage());
				   }
				   session.flush();
				   System.out.println("MOrderDetailBean資料新增成功");  
//TicketBean
				   try (FileReader fr = new FileReader("data/ticket.dat"); BufferedReader br = new BufferedReader(fr);) {
					    while ((line = br.readLine()) != null) {
					     if (line.startsWith(UTF8_BOM)) {
					      line = line.substring(1);
					     }
					     String[] token = line.split("\\|");
					     TicketBean tb = new TicketBean();
					    
					     MOrderBean mob = session.get(MOrderBean.class, Integer.parseInt(token[0]));
					     tb.setmOrderBean(mob);
					     SeatsBean sb = session.get(SeatsBean.class, token[1]);
					     tb.setSeatsBean(sb);
					    
					     session.save(tb);
					    }
					   } catch (IOException e) {
					    System.err.println("新建TicketBean表格時發生IO例外: " + e.getMessage());
					   }
					   session.flush();
					   System.out.println("TicketBean資料新增成功");  	   
//ExpectationBean
			try (FileReader fr = new FileReader("data/Expectation.dat"); BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					ExpectationBean eb = new ExpectationBean();

					eb.setExpective(Integer.parseInt(token[0]));
					MovieBean mvb = session.get(MovieBean.class, Integer.parseInt(token[1]));
					eb.setMovieBean(mvb);
					MemberBean mb = session.get(MemberBean.class, Integer.parseInt(token[2]));
					eb.setMemberBean(mb);

					session.save(eb);
				}
			} catch (IOException e) {
				System.err.println("新建Expectation表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("Expectation資料新增成功");
			
//CommentBean
			try (FileReader fr = new FileReader("data/Comment.dat"); BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					CommentBean cb = new CommentBean();

					cb.setWatched(Integer.parseInt(token[0]));
					cb.setGrade(Integer.parseInt(token[1]));
					cb.setCommentContent(token[2]);
					cb.setCommentTime(token[3]);
					cb.setReportComment(Integer.parseInt(token[4]));
					cb.setCommentDelete(Integer.parseInt(token[5]));
					MovieBean mvb = session.get(MovieBean.class, Integer.parseInt(token[6]));
					cb.setMovieBean(mvb);
					MemberBean mb = session.get(MemberBean.class, Integer.parseInt(token[7]));
					cb.setMemberBean(mb);

					session.save(cb);
				}
			} catch (IOException e) {
				System.err.println("新建Comment表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("Comment資料新增成功");
			
//PreferenceBean
			try (FileReader fr = new FileReader("data/Preference.dat"); BufferedReader br = new BufferedReader(fr);) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					PreferenceBean pb = new PreferenceBean();

					CommentBean cb = session.get(CommentBean.class, Integer.parseInt(token[0]));
					pb.setCommentBean(cb);
					MemberBean mb = session.get(MemberBean.class, Integer.parseInt(token[1]));
					pb.setMemberBean(mb);
					pb.setGood(Integer.parseInt(token[2]));
					pb.setBad(Integer.parseInt(token[3]));
					pb.setBlock(Integer.parseInt(token[4]));


					session.save(pb);
				}
			} catch (IOException e) {
				System.err.println("新建Preference表格時發生IO例外: " + e.getMessage());
			}
			session.flush();
			System.out.println("Preference資料新增成功");
			
//SCOrderDetailsBean
			try (FileReader fr = new FileReader("data/SCOrders.dat"); BufferedReader br = new BufferedReader(fr);) {

				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");

					SCOrdersBean scob = new SCOrdersBean();

					scob.setsCOrderID(Integer.parseInt(token[0]));
					scob.setMemo(token[1]);
					scob.setOrdDate(token[2]);
					scob.setShippingAddress(token[3]);
					scob.setTotal(Integer.parseInt(token[4]));
					MemberBean mb = session.get(MemberBean.class, Integer.parseInt(token[5]));
					scob.setMemberBean(mb);
					PayStatusBean psb = session.get(PayStatusBean.class, Integer.parseInt(token[6]));
					scob.setPayStatusBean(psb);
					ShippingStatusBean ssb = session.get(ShippingStatusBean.class, Integer.parseInt(token[7]));
					scob.setShippingStatusBean(ssb);
					session.save(scob);
				}
			} catch (IOException e) {
				System.err.println("新建SCOrders表格時發生IO例外: " + e.getMessage());
			}
				session.flush();
				System.out.println("SCOrders資料新增成功");
				
//SCOrderDetailsBean
				try (FileReader fr = new FileReader("data/SCOrderDetails.dat"); BufferedReader br = new BufferedReader(fr);) {

					while ((line = br.readLine()) != null) {
						if (line.startsWith(UTF8_BOM)) {
							line = line.substring(1);
						}
						String[] token = line.split("\\|");

					SCOrderDetailBean scodb = new SCOrderDetailBean();

						scodb.setOrderno(Integer.parseInt(token[0]));
						scodb.setQuantity(Integer.parseInt(token[1]));
						SCOrdersBean scob = session.get(SCOrdersBean.class, Integer.parseInt(token[2]));
						scodb.setSCOrdersBean(scob);
						ProductsBean pb = session.get(ProductsBean.class, Integer.parseInt(token[3]));
						scodb.setProductsBean(pb);
						session.save(scodb);
					}
				} catch (IOException e) {
					System.err.println("新建SCOrderDetails表格時發生IO例外: " + e.getMessage());
				}
				session.flush();
				System.out.println("SCOrderDetails資料新增成功");
				
//QuestionBean
				try (FileReader fr = new FileReader("data/question.dat"); BufferedReader br = new BufferedReader(fr);) {

					while ((line = br.readLine()) != null) {
						if (line.startsWith(UTF8_BOM)) {
							line = line.substring(1);
						}
						String[] token = line.split("\\|");

						QuestionBean qb = new QuestionBean();

						MemberBean mb = session.get(MemberBean.class, Integer.parseInt(token[1]));
						qb.setMemberBean(mb);
						QuestionStatusBean qsb = session.get(QuestionStatusBean.class, Integer.parseInt(token[2]));
						qb.setQuestionStatusBean(qsb);
						session.save(qb);
					}
				} catch (IOException e) {
					System.err.println("新建Question表格時發生IO例外: " + e.getMessage());
				}
				session.flush();
				System.out.println("Question資料新增成功");
				
				
//QuestionContentBean
				try (FileReader fr = new FileReader("data/questionContent.dat"); BufferedReader br = new BufferedReader(fr);) {

					while ((line = br.readLine()) != null) {
						if (line.startsWith(UTF8_BOM)) {
							line = line.substring(1);
						}
						String[] token = line.split("\\|");

						QuestionContentBean qcb = new QuestionContentBean();

						qcb.setDatetime(token[0]);
						QuestionBean qb = session.get(QuestionBean.class, Integer.parseInt(token[1]));
						qcb.setQuestionBean(qb);
						qcb.setContent(token[2]);
						qcb.setName(token[3]);

						session.save(qcb);
					}
				} catch (IOException e) {
					System.err.println("新建questionContent表格時發生IO例外: " + e.getMessage());
				}
				session.flush();
				System.out.println("questionContent資料新增成功");
				
				
//======假資料表格往上新增=======================================================================			

			tx.commit();
		} catch (Exception e) {
			System.err.println("新建表格時發生例外: " + e.getMessage());
			e.printStackTrace();
			tx.rollback();
		}
		factory.close();
	}

}