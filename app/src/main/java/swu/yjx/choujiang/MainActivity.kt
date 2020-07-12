package swu.yjx.choujiang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    //保存抽奖名单（数组）
    var names = listOf<String>("杨大力","郭大力","孙大力")
    //做个定时器，每隔一段时间切换一次名字

    lateinit var timer: Timer

    //记录当前索引
    var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        //设置默认显示第一人
        mNameTextView.text = names[index]
        //给按钮添加点击事件
        mStartBtn.setOnClickListener {
            //判断标题提示是Start还是stop
            if (mStartBtn.text.toString()=="START"){
                mStartBtn.text = "STOP"
                //创建定时器
                timer = Timer()
                //设置分配一个定时任务
                timer.schedule(object: TimerTask(){
                    override fun run() {
                        //判断是否越界
                        index = if (index + 1 > names.size-1) 0 else index+1

                        //取出对应名字
                        mNameTextView.text = names[index]
                        //改变索引值

                    }
                },0,100)
            }else{
                mStartBtn.text = "START"
                timer.cancel()
            }
        }
    }
}
