using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using Senparc.Weixin.MP.AdvancedAPIs;
using Ad = Senparc.Weixin.MP.AdvancedAPIs;
using Weixin;
using Senparc.Weixin.MP.Entities;

namespace WeixinD
{
    public partial class sendnews : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                string text = Request.Form["idtxt"];
                string accessToken = Wx.accessToken;

                #region 上传永久单图片素材
                //Ad.Media3.UploadForeverMediaResult result =  MediaApi.UploadForeverMedia(accessToken,Server.MapPath("~/img/a3.jpg"));
                //Response.Write(result.media_id);
                #endregion


                #region 永久图文素材初始化
                string title_str = "异步编程一些示例";
                string thumb_media_id_str = "o4WZ7jhwtKOHuI5ntNw8J6qPfuuayC7yL1S3JcvRz0c";
                string author_str = "wu";
                string digest_str = "";
                string show_cover_pic_str = "1";
                string content_str = @"## 一些示例 


-   [取消一个异步任务或一组任务(C#)]()。  

-   [在一段时间后取消异步任务 (C#)]()  
  
-   [在完成一个异步任务后取消剩余任务 (C#)]()  
  
-   [启动多个异步任务并在其完成时进行处理 (C#)]()  
  
项目将创建一个 UI，其中包含用于启动进程和取消进程的按钮，如下图所示。 这些按钮名为 `startButton` 和 `cancelButton`。  
![这里写图片描述](https://img-blog.csdn.net/20180607203930214)  


# 取消一个异步任务或一组任务 (C#)
如果不想等待异步应用程序完成，可以设置一个按钮用来取消它。 通过遵循本主题中的示例，可以为下载一个或一组网站内容的应用程序添加一个取消按钮。
   
### 取消一个任务  
下列代码是取消单个任务示例的完整 MainWindow.xaml.cs 文件。  

```csharp  
using System;  
using System.Collections.Generic;  
using System.Linq;  
using System.Text;  
using System.Threading.Tasks;  
using System.Windows;  
using System.Windows.Controls;  
using System.Windows.Data;  
using System.Windows.Documents;  
using System.Windows.Input;  
using System.Windows.Media;  
using System.Windows.Media.Imaging;  
using System.Windows.Navigation;  
using System.Windows.Shapes;  
using System.Net.Http;    
using System.Threading;
  
namespace CancelATask  
{  
    public partial class MainWindow : Window  
    {  
        //声明一个System.Threading.CancellationTokenSource.  
        CancellationTokenSource cts;  
  
        public MainWindow()  
        {  
            InitializeComponent();  
        }  
  
        private async void startButton_Click(object sender, RoutedEventArgs e)  
        {  
            //实例化CancellationTokenSource.  
            cts = new CancellationTokenSource();  
  
            resultsTextBox.Clear();  
  
            try  
            {   
                //如果请求取消，则发送令牌以携带消息。
                int contentLength = await AccessTheWebAsync(cts.Token);  
                resultsTextBox.Text +=  
                    String.Format(""\r\nLength of the downloaded string: {0}.\r\n"", contentLength);  
            }   
            catch (OperationCanceledException)  
            {  
               //如果请求取消，则返回OperationCanceledException
                resultsTextBox.Text += ""\r\nDownload canceled.\r\n"";  
            }  
            catch (Exception)  
            {  
                resultsTextBox.Text += ""\r\nDownload failed.\r\n"";  
            }  
  
            //下载完成后，将CancellationTokenSource设置为空
            cts = null;   
        }  
   
        //为Cancel 按钮添加一个事件处理程序。
        private void cancelButton_Click(object sender, RoutedEventArgs e)  
        {  
            if (cts != null)  
            {  
                cts.Cancel();  
            }  
        }  
   
        //提供一个CancellationToken参数
        async Task<int> AccessTheWebAsync(CancellationToken ct)  
        {  
            HttpClient client = new HttpClient();  
  
            resultsTextBox.Text += String.Format(""\r\nReady to download.\r\n"");  
  
            //您可能需要放慢速度才能有机会取消。
            await Task.Delay(2500);  
   
            //GetAsync返回一个Task<HttpResponseMessage> 
            //如果选择Cancel按钮，则ct参数将携带消息。
            HttpResponseMessage response = await client.GetAsync(""http://www.twitter.com/dd470362.aspx"", ct);  
  
           
            //从HttpResponseMessage中检索网站内容
            byte[] urlContents = await response.Content.ReadAsByteArrayAsync();  
  
            //该方法的结果是下载网站页面的字符长度
            return urlContents.Length;  
        }  
    }  
  
    // 成功下载的输出：
  
    // Ready to download.  
  
    // Length of the downloaded string: 158125.  
  
  
    // 或者，如果取消:  
  
    // Ready to download.  
  
    // Download canceled.  
}  
```
";
                string content_source_url_str = "https://blog.csdn.net/WuLex/article/details/88238022";
                string need_open_comment_str = "0";
                string only_fans_can_comment_str = "0";
                #endregion

                #region 上传永久图文素材
                Ad.GroupMessage.NewsModel[] list = new Ad.GroupMessage.NewsModel[] {

                    new Ad.GroupMessage.NewsModel
                    { title=title_str,
                      author=author_str,
                       content=content_str,
                        digest=digest_str,
                     content_source_url=content_source_url_str,
                      show_cover_pic=show_cover_pic_str,
                       thumb_media_id=thumb_media_id_str,
                        thumb_url="https://mmbiz.qpic.cn/mmbiz_jpg/hjjPWAYzbJLBftDP3JqTN6yiaIU7P5CHaicH5sO69LRT0BbTVC4yCKznTvJ4Ak3JbSvWuInoHuaXvGvz2qOHaGlA/0"

                     }
                };
                Ad.Media3.UploadForeverMediaResult fmr = MediaApi.UploadNews(accessToken, list);

                Response.Write(fmr.media_id);
                Response.Write(fmr.url);
                #endregion
                //实验回复新闻消息
                /*
                var l = Ad.User.List(accessToken, "");
                string opid=l.data.openid.ToString();
                if (text == opid)
                {
                    List<Article> News = new List<Article>();
                    News.Add(new Article
                    {
                        
                        PicUrl = "http://linux.qicp.vip/img/a3.jpg",
                        Url = "http://linux.qicp.vip/index.aspx",
                        Title = "wulex 男 20190518123"
                    });
                    News.Add(new Article
                    {
                        PicUrl = "http://linux.qicp.vip/img/a1.jpg",
                        Description = "访问ViewNav页面",
                        Url = "http://linux.qicp.vip/ViewNav.aspx",
                        Title = "访问记录统计"
                    });
                    News.Add(new Article
                        {
                            PicUrl = "http://linux.qicp.vip/img/a2.jpg",
                            Description = "访问ViewNav页面",
                            Url = "http://linux.qicp.vip/ViewShare.aspx",
                            Title = "访问记录统计"
                        });
                    
                }
                int n = 0;
                foreach (var i in l.data.openid)
                {
                    try
                    {
                        CustomerService.SendText(accessToken, i, text);
                        n++;
                    }
                    catch { }
                }
                ClientScript.RegisterStartupScript(GetType(), "k", string.Format("alert('成功向{0}个用户发送消息');", n), true);
                */
            }
        }
    }
}