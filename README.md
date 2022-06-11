# 想到什麼要用的就直接寫到上面就好
我每次要做會看一下

# 格式： 需要資料（型態）
如果型態是多層包裝就寫在另一行展開
可以直接看我下面的來寫
英文名字可能會改因為我英文太爛

# 查詢類
用戶(User)： userId(ID) 用戶名(String) 學校(String) 手機(String) 郵箱(String) 密碼(String) 積分(Int) 頭像圖片(String) 時間(Time) 

貼文(Post)： postId(ID) 作者(String) 貼文類型(Strin) 物品類型(String) 地點(String)  物品圖片(String)  物品描述(String) 是否取回(Boolean) 懸賞積分(Int) 匿名(Boolean) 時間(Time)

排行榜(Ranking)： 學校(String) 學校積分(Int) 

任务(Quest): 用戶名(String), Quest1進度(Int), Quest2(進度), Quest3(進度)

用戶道具(UserItem): 用戶名(String), orangeFlag數量(Int), purpleFlag數量(Int), yellowFlag數量(Int), blueFlag數量(Int), shit數量(Int), vaccine數量(Int)

商店道具(ShopItem): 道具種類(Int), 價格(Int),

地圖道具(MapItem): 道具種類(Int), latitude(Double), longitude(Double), userName(String), userSchool(String)

聊天(Chat)：發送者(String), 接受者(String), 訊息(String), 時間(Time)

幫助者(Helper): postId(String), helperName(String)

通知(Noti): receive(String), send(String), postId(String), 時間(Time)

# 修改類

積分 道具 貼文 任務 通知 地點 物品類型

# TODO
Main Flow
create
login A
lost
如果有找到→看定位→取回
如果沒有→發佈新貼文→選照片→編輯貼文→完成任務
切換B
find→協助歸還→聊天
切回A
聊天室檢查聊天
我的貼文按完成貼文→展現錢又被扣到→歷史帖文
ranking
買道具→放道具按一下就好