# 반려동물 앱 "부탁해, 집사 !" 🐕 🐈 

## 발표 영상 https://www.youtube.com/watch?v=-lIob90ukPA&feature=youtu.be 

<201621453 김현승, 201921041 김민진, 201921067 신정은, 201921080 이소윤, 201921085 임재은, 201921093 진수현>
***

# 목차
 ## 1. 소개
>  ### 1-1 개발배경
>  ### 1-2 사용한 기능
>  ### 1-3 기존 어플과의 차이
>  ### 1-4 기대효과

## 2. 기능 구현
> ### 2-1 사용자 생성
> > ### 2-1-1 Firebase와 Android Studio 연동
> > ### 2-1-2 회원가입
> > ### 2-1-3 로그인
>
> ### 2-2 가족 연동
> > ### 2-2-1 가족 연동
> > ### 2-2-2 가족 프로필
>
> ### 2-3 동물 등록 
> > ### 2-3-1 동물 사진 등록 및 메인 화면에 불러오기
> > ### 2-3-2 동물 정보 저장
>
> ### 2-4 기능 1 -  밥
> > ### 2-4-1 밥 정보 입력 팝업창
> > ### 2-4-2 밥 정보 저장 및 리스트 출력
> ### 2-5 기능 2 - 간식
> > ### 2-5-1 간식 정보 입력 팝업창
> > ### 2-5-2 간식 정보 저장 및 리스트 출력
> ### 2-6 기능 3 - 산책
> > ### 2-6-1 산책 정보 입력 팝업창
> > ### 2-6-2 산책 정보 저장 및 리스트 출력
> > ### 2-6-3 산책 메이트
> > ### 2-6-4 산책 메이트 정보 입력 팝업창
> > ### 2-6-5 산책 메이트 정보 저장 및 리스트 출력
> > ### 2-6-6 근처 공원 찾기
> ### 2-7 기능 4 - 건강
> > ### 2-7-1 건강 정보 입력 팝업창
> > ### 2-7-2 건강 정보 저장 및 리스트 출력
> > ### 2-7-3 근처 병원 찾기
> > ### 2-7-4 다이어리
> > ### 2-7-5  알림설정
> ### 2-8 기능 네비게이션


## 1.소개
### 1-1 개발배경
간식으로 인한 비만 또는 산책을 안함으로써 생기는 배변 장애는 반려동물에게 흔히 나타나는 건강문제이다. 이를 해결하기 위해서는 가족의 의사소통과 무한한 관심이 중요하다. 그러나, 반려동물을 키우는 입장에서 혼자가 아닌 가족 구성원과 함께 관심을 가지고 모두가 케어해야 한다고 생각한다. 이러한 문제점을 토대로 기존 어플을 조사해보니 반려동물에 대한 어플 중 아직까지 가족들과 함께 공유할 수 있는 앱이 존재하지 않은 것을 확인하였다. 그 후 반려동물에 관한 앱을 개발함으로써 많은 집사들에게 활용적이게 사용할 수 있는 앱이 될 것 같아 주제를 선정하였다.

### 1-2 사용한 기능
부탁해 집사! 서비스 애플리케이션은 모든 가족 구성원끼리 반려동물을 케어 할 수 있게 가족연동을 통하여 반려동물들의 밥, 간식, 건강, 산책 등의 정보를 실시간으로 공유할 수 있다. 또한 google map과 연동을 통하여 내 주변에 공원 위치와 병원 위치를 알 수 있게 함으로서 모든 집사들이 책임감을 가지고 반려동물을 편리하게 서비스를 제공 하는 것을 목표로 구성하였다.
Firebase을 Android Studio와 연결하여 테이터 저장을 통하여 여러 기능들을 구현하고 Google Map API 연동을 통해 실시간 위치와 Place API을 이용하여 공원 위치와 병원 위치를 찾을 수 있도록 한다.

### 1-3 기존 어플과의 차이
저의 어플의 가장 큰 차이점은 가족연동입니다. 기존에 다른 반려동물 관리 어플은 구현되어 있는것이 있지만 저희 어플처럼 가족연동으로 구현된 어플은 없었습니다. 집에서 키우는 반려동물인 만큼 가족구성원이 다같이 돌보고 있지만 그만큼 서로 소통하는것에 번거로움이 발생할 수 있습니다. 저희 어플을 통해 기록으로 남김으로써 언제든지 가족 구성원이 체크를 할 수있으면 사용자 또한 손쉽게 클릭으로 기록을 바로바로 할 수있어 번거로움도 최소화 시킬 수있습니다. 또 그밖의 병원찾기기능이나 산책메이트 찾기와 같이 효율성을 증가시킬수 있는 기능들을 추가하여 관리의 편리함을 증가시켰다는것을 장점으로 볼 수있습니다.

### 1-4 기대효과
많은 가구에서 반려동물을 키우고 있어 반려동물 관리에 많은 관심이 쏟아지고 있는 요즘, 다양하게 반려동물에 대한 용품이나 그밖의 여러가지 관리를 위한것들이 나타나고 있다. 이에 걸맞게 많은 가구에서 유용하게 쓰여질 수 있는 반려동물 관리 어플을 만듬으로써 직접적으로 소통을 하지 않고도 정보 입력을 통해 서로 내용들을 공유하고 번거로움을 줄일 수 있으며 검색을 하지 않고도 주변 병원 또한 찾아볼 수 있어  가족 구성원이 좀 더 효율적으로 동물들을 보살필수 있을것이다. 그뿐만아니라 가족구성원이 각자 사진을 올리고 글을 작성하면서 가족간의 소통의 기회 또한 늘어나게 해줄것이라 기대한다.


***
## 2. 기능 구현
### 2-1 사용자 생성
#### 2-1-1 Firebase와 Android Studio 연동
 회원가입과 로그인 및 건강,산책,다이어리,가족연동 을 위해 데이터를 저장해 놓을 Firebase가 필요하다.
 
[연동 방법] 
1. 파이어 베이스에 프로젝트 생성
2. google-service.json파일얻기
3. .json파일을 안드로이드스튜디오 프로젝트 안에 삽입 
4. Firebase SDK추가
5. 안드로이드와 파이어베이스 연결 확인

[연동방법- realtime database]
1. TOOL에들어간후, 파이어베이스 클릭
2. realtime database를 찾은 후 클릭
3. Connect firebase를 하여 생성한 파이어베이스와 연동
4. add to realtime database to your app 을 클릭하여 자동으로 build.gradle에 코드가 추가되게 만들어줌

#### 2-1-2 회원가입
이메일로 회원가입을 진행할 수 있도록 하였다. 사용자의 이메일, 비밀번호를 입력하여 저장하여, 파이어베이스에 정보가 올라갈 수 있고도록 만들었다.   
Register.java 생성

    public class Register extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;
    private EditText mEtEmail,mEtpwd;
    private Button mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Family login"); //파이어베이스에 회원가입 정보 저장

        mEtEmail = findViewById(R.id.et_email);
        mEtpwd = findViewById(R.id.et_pwd);
        mBtnRegister = findViewById(R.id.btn_register);

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //회원가입 처리시작
                String strEmail = mEtEmail.getText().toString();
                String strPwd = mEtpwd.getText().toString();

                //파이어베이즈 어스 진행
                mFirebaseAuth.createUserWithEmailAndPassword(strEmail,strPwd).addOnCompleteListener(
                        Register.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if(task.isSuccessful()){
                            FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                            UserAccount account = new UserAccount();
                            account.setIdToken(firebaseUser.getUid());
                            account.setEmailId(firebaseUser.getEmail());
                            account.setPassword(strPwd);

                            mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);

                            Toast.makeText(Register.this,"회원가입에 성공하셨습니다.",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Register.this,Login.class); //회원가입 성공시 로그인 화면 전환 
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(Register.this,"회원가입에 실패하셨습니다.",Toast.LENGTH_SHORT).show();
                            //회원가입 실패시 토스트 메시지 출력
                        }
                    }
                });
            }
        });
    }
    }

 UserAccount.java - 회원가입 정보을 저장해둘 class 생성
  
    public class UserAccount{
    private String idToken; // Firebase Uid( 고유토큰정보)
    private String emailId;
    private String password;
    public UserAccount() {    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    }
![image](https://user-images.githubusercontent.com/79950380/121208194-d9e0f800-c8b4-11eb-8dac-a9cd04eda8e3.png)

#### 2-1-3 로그인
 회원가입을 완료 되었다면 로그인을 할 수 있다. 파이어베이스에 있는 정보와 입력된 정보를 비교하여 등록되어있다면 로그인 성공 메시지가 뜨고 메인화면으로들어간다. 아이디나 비밀번호가 일치하지 않거나 등록되지 않은 아이디라면 로그인 실패 메시지가 뜨면서 화면이 넘어가지 않는다.   
 Login.java

    public class Login extends AppCompatActivity{
    private FirebaseAuth mFirebaseAuth; //파이어 베이스 인증
    private DatabaseReference mDatabaseRef; //실시간 데이터 베이스
    private EditText mEtEmail,mEtpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Family login");

        mEtEmail = findViewById(R.id.et_email);
        mEtpwd = findViewById(R.id.et_pwd);

        Button btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //로그인요청
                String strEmail = mEtEmail.getText().toString();
                String strPwd = mEtpwd.getText().toString();
                //파이어베이스 등록된 아이디 & 비밀번호 확인
                mFirebaseAuth.signInWithEmailAndPassword(strEmail,strPwd).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //로그인 성공
                            Intent intent = new Intent(Login.this,Family_Register.class);
                            startActivity(intent);
                            finish(); //현 엑티비티 파괴
                        }else{
                            Toast.makeText(Login.this,"로그인 실패",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        Button btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //회원가입화면으로 이동
                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });
    }
    }
![image](https://user-images.githubusercontent.com/79950380/121208285-e9f8d780-c8b4-11eb-9f9d-5083d2a5cc73.png)


***
## 2-2 가족 연동
### 2-2-1 가족 구성원 프로필 입력 및 출력
한 아이디를 통해 가족들이 로그인을 하고 가족 구성원을 등록한다. 가족 구성원에 등록되면 스피너에 연결되어 밥 , 산책, 간식 팝업창에서 등록된 가족들을 선택하여 정보를 저장 할 수 있다.
등록이 되면 가족 구성원 프로필 리스트로 출력된다.   
Family_Register.java - 가족 프로필 등록

    public class Family_Register extends AppCompatActivity  {

    TextView tv;
    EditText Name;
    EditText age;
    EditText NickName;
    Button btn_pet, btn_pet2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.family__register);

        tv = findViewById(R.id.tv);
        Name = findViewById(R.id.Name);
        age = findViewById(R.id.age);
        NickName = findViewById(R.id.NickName);
        btn_pet = findViewById(R.id.btn_pet);
        btn_pet2 = findViewById(R.id.btn_pet2);

        btn_pet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Pet_Register.class);
                startActivity(intent);
            }
        });

        btn_pet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Pet_Main.class);
                startActivity(intent);
            }
        });
    }


        public void clickSave (View v) {


            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference rootRef = firebaseDatabase.getReference("Family Pet");

            String name = Name.getText().toString();
            String Age = age.getText().toString();
            String Nickname = NickName.getText().toString();

            Person person = new Person(name, Age, Nickname);

            DatabaseReference personRef = rootRef.child("persons");
            personRef.push().setValue(person);

            personRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    StringBuffer buffer = new StringBuffer();

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        Person person = snapshot.getValue(Person.class);
                        String name = person.getName();
                        String Age = person.getAge();
                        String Nickname = person.getNickName();

                        buffer.append("이름 : " + name + "\n" + "나이 : " + Age + "\n" + "별명 : " + Nickname + "\n\n");
                    }
                    tv.setText(buffer);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }

    }
    
Person.java - 가족 정보를 저장할 class 생성

    public class Person {

    String name;
    String age;
    String NickName;

    public Person(String name, String Age, String Nickname) {
        this.name = name;
        this.age = Age;
        this.NickName = Nickname;
    }

    public Person(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAge() {
        return age;
    }

    public void setAge(String Age) {
        this.age = Age;
    }


    public  String getNickName() {
        return NickName;
    }

    public  void setNickName(String Nickname) {
        this.NickName = Nickname;
    }
    }

### 2-2-2 가족 연동
가족 구성원을 등록하면 밥, 간식, 산책에 가족들을 스피너로 연결하여 가족 연동을 구현하였다.   
Pet_Database.java

    public class Pet_Database { //데이터베이스에 저장된 가족 이름 연결
    public static void getPersons(OnSuccessListener<DataSnapshot> onSuccessListener) {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference rootRef = firebaseDatabase.getReference("Family Pet");
        DatabaseReference personRef = rootRef.child("persons");

        personRef.get().addOnSuccessListener(onSuccessListener);
    }
    }
 
Register_Food.java,  Register_Run.java, Register_Snack.java 파일에 넣어준다.

    private void setNameSpinner(Spinner nameSpinner) { //파이어베이스에 저장된 가족이름이 있다면 불러옴.
        Pet_Database.getPersons(dataSnapshot -> {
            List<String> persons = new ArrayList<>();
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                Person person = snapshot.getValue(Person.class);
                if (person != null) {
                    persons.add(person.name);
                }
            }

            final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>( // 불러온 데이터를 스피너 값에 넣어줌.
                    this, android.R.layout.simple_spinner_dropdown_item, persons);
            spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            nameSpinner.setAdapter(spinnerArrayAdapter);
        });
    }
    
    setNameSpinner(Person); //스피너에 저장된 스피너값 연결
![image](https://user-images.githubusercontent.com/79950380/121206758-b0739c80-c8b3-11eb-87c1-fd9659803f17.png)
***
## 2-3 동물 등록 
### 2-3-1 동물 사진 등록 및 메인 화면에 불러오기, 데이터 저장
동물의 사진을 갤러리를 통해 직접 가져오거나 사진 촬영을 통해 등록할 수 있다.
그밖의 성별과 이름, 품종, 생년월일을 입력하여 등록을 완성한다. 저장이 완료 되었다면 등록된 사진이 메인화면에 출력된다. 
동물 정보 저장 완료후 메인으로 왔을때 등록한 동물의 이미지가 뜬다면 동물 등록에 성공하였다.
동물의 이미지와 함께 아래에는 동물의 건강, 밥, 산책, 간식의 정보를 등록할 수 있는 버튼이 뜨고 이를 통해 정보를 작성할 수 있는 페이지로 이동할 수 있다.

Pet_Register.java 

    public class Pet_Register extends AppCompatActivity {
    private Button btnCamera, btnGallery, btnSave;
    private ImageView animalImg;
    private ProgressBar progressBar;
    private EditText Name , Kind,birthday;

    final  int CAMERA_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pet__register);
        Name = findViewById(R.id.editTextTextPersonName);
        Kind = findViewById(R.id.editTextTextPersonName5);
        birthday = findViewById(R.id.editTextTextPersonName2);


        btnCamera = (Button)findViewById(R.id.btnCamera);
        btnGallery = (Button)findViewById(R.id.btnGallery);
        animalImg = (ImageView)findViewById(R.id.Animal_img);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnCamera.setOnClickListener(new View.OnClickListener(){
            // 카메라 연결
            @Override
            public void onClick(View v) {
                if(IsCameraAvailable()){
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                    startActivityForResult(intent, CAMERA_REQUEST_CODE);
                }
            }
        });

        btnGallery.setOnClickListener(new View.OnClickListener() {
            //갤러리 연결
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 2);
            }
        });

        btnSave.setOnClickListener(view -> {
            //파이어베이스에 동물 정보 저장
            FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
            DatabaseReference rootRef= firebaseDatabase.getReference("Family Pet");
            String name = Name.getText().toString();
            String kind = Kind.getText().toString();
            String Birthday = birthday.getText().toString();

            Pet pet = new Pet(name, kind,Birthday);

            DatabaseReference PetRef = rootRef.child("pet");
            PetRef.push().setValue(pet);

            BitmapDrawable bitmapDrawable = (BitmapDrawable) animalImg.getDrawable();
            if (bitmapDrawable == null) {
                return;
            }

            Bitmap bitmap = bitmapDrawable.getBitmap();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos) ;
            uploadImage(bos.toByteArray());

        });
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE) {
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");
            animalImg.setImageBitmap(bitmap);
        } else if (requestCode == 2) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                try {
                    // 선택한 이미지에서 비트맵 생성
                    InputStream in = getContentResolver().openInputStream(data.getData());
                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();
                    // 이미지 표시
                    animalImg.setImageBitmap(img);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void uploadImage(byte[] bytes) {
        //카메라와 갤러리에서 가져오기 성공 시 이미지뷰에 넣기
        progressBar.setVisibility(View.VISIBLE);
        PetStorage.uploadPetImage(bytes, onProgress -> {
            double value = (100.0 * onProgress.getBytesTransferred()) / onProgress.getTotalByteCount();
            int progress = (int) Math.round(value);
            progressBar.setProgress(progress);
        }, onSuccess -> {
            Toast.makeText(this, "이미지 등록 성공", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
        }, onFailure -> {
            Toast.makeText(this, "이미지 등록 실패", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
        });
    }

PetStorage 함수 - 동물 사진 파이어베이스 저장

    public class PetStorage {
    //파이어베이스 스토리지에 이미지 저장
    private static final String TAG = "PetStorage";

    public static void uploadPetImage(byte[] data,
                                      OnProgressListener<UploadTask.TaskSnapshot> onProgressListener,
                                      OnSuccessListener<UploadTask.TaskSnapshot> onSuccessListener,
                                      OnFailureListener onFailureListener) {
        String uid = getCurrentUserUid();
        if (uid == null) {
            return;
        }

        StorageReference petImage = getStorageReference(uid);

        // async 비동기적으로
        UploadTask uploadTask = petImage.putBytes(data);
        uploadTask.addOnProgressListener(onProgressListener)
                .addOnSuccessListener(onSuccessListener)
                .addOnFailureListener(onFailureListener);
    }

    public static void getPetImageUrl(OnSuccessListener<Uri> onSuccessListener, OnFailureListener onFailureListener) {
        //이미지 가져오기 성공 시 파이에베이스 스토리지에 올리기, 실패시 기본 이미지
        String uid = getCurrentUserUid();
        if (uid == null) {
            return;
        }

        StorageReference petImage = getStorageReference(uid);
        // async 비동기
        petImage.getDownloadUrl()
                .addOnSuccessListener(onSuccessListener)
                .addOnFailureListener(onFailureListener);
    }

    private static StorageReference getStorageReference(String uid) {
        //가져온 이미지 url로 바꿔줌.
        final FirebaseStorage storage = FirebaseStorage.getInstance();
        //storageRef -> gs://project-pet-ba709.appspot.com/
        final StorageReference storageRef = storage.getReference();

        // userFolder -> gs://project-pet-ba709.appspot.com/uid/
        StorageReference userFolder = storageRef.child(uid);

        // return -> gs://project-pet-ba709.appspot.com/uid/petImage
        return userFolder.child("petImage");
    }

    @Nullable
    private static String getCurrentUserUid() {
        //파이어베이스에서 사용자 id 아이디 가져오기
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            return null;
        }

        return user.getUid();
    }
    }
    
 Pet_Main.java 에 이미지 불러오기
 
      private void postPetImage() {
        //성공시 저장된 이미지 불러오기
        PetStorage.getPetImageUrl(uri -> {
            // 외부 라이브러리 Glide를 사용해서 Firebase PetStorage의 이미지 로딩
            Glide.with(this)
                    .load(uri)
                    .addListener(getRequestListener())
                    .into(petImage);
        }, exception -> {
            petImage.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.dog, this.getTheme()));
            progressBar.setVisibility(View.GONE);
        });
    }
 ![image](https://user-images.githubusercontent.com/51051548/121143591-2e19b700-c878-11eb-83d7-002afeb12888.png)
 ***
## 2-4 기능 1 -  밥
### 2-4-1 밥 정보 입력 팝업창

준 사람, 준 시간, 사료 종류, 사료 양을 + 버튼을 통해 입력 할 수 있는 팝업창을 구현하였다.
준 사람, 사료 종류, 사료 양은 스피너로 등록하여 선택 할 수 있게 하였고, 준 시간은 Now 버튼을 클릭 하면 실시간 날짜와 시간을 입력 받을 수 있다. 준 사람 스피너는 앞에서 가족 등록을 통하여 등록 된 가족구성원을 선택 할 수 있다.
권장량 버튼을 클릭 시 알맞은 사료의 양을 볼 수 있다.   

Register_Food.java

    public class Register_Food extends AppCompatActivity {

    private final ArrayList<Food> listFood = new ArrayList<>();
    private RecyclerView recyclerView1;
    private RecyclerAdapter_food adapter1;
    private  RecyclerView.LayoutManager layoutManager1;
    private DrawerLayout drawerLayout;
    private View drawerView;

    private FloatingActionButton add1, look1;

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.register__food);

        
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerView = (View)findViewById(R.id.drawer);
        recyclerView1 = (RecyclerView) findViewById(R.id.food_list);
        recyclerView1.setHasFixedSize(true);
        layoutManager1 = new LinearLayoutManager(this);
        ((LinearLayoutManager) layoutManager1).setReverseLayout(true);
        ((LinearLayoutManager) layoutManager1).setStackFromEnd(true);

        add1 = findViewById(R.id.foodButton2);
        look1 = findViewById(R.id.foodButton);

        recyclerView1.setLayoutManager(layoutManager1);
        adapter1 = new RecyclerAdapter_food(listFood);

        recyclerView1.setAdapter(adapter1);

        //파이어베이스 연결
        FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
        DatabaseReference rootRef = firebaseDatabase.getReference();

        //네비게이션 연결
        Button Btn1 = (Button)findViewById(R.id.Btn1);
        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_f =new Intent(Register_Food.this,Register_Food.class);
                startActivity(intent_f);
            }
        });
        Button Btn2 = (Button)findViewById(R.id.Btn2);
        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_s =new Intent(Register_Food.this,Register_Snack.class);
                startActivity(intent_s);
            }
        });
        Button Btn3 = (Button)findViewById(R.id.Btn3);
        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_h =new Intent(Register_Food.this,Register_Health.class);
                startActivity(intent_h);
            }
        });
        Button Btn4 = (Button)findViewById(R.id.Btn4);
        Btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_r =new Intent(Register_Food.this,Register_Run.class);
                startActivity(intent_r);
            }
        });

        Button btn_close = (Button)findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawers();
            }
        });

        drawerLayout.setDrawerListener(listener);
        drawerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        // + 버튼 클릭 시 입력 팝업 창 생성
        add1.setOnClickListener(new View.OnClickListener() {
            ArrayAdapter<CharSequence>adspin1, adspin2, adspin3;
            String choice_do="";
            String choice_se="";

            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder1 = new AlertDialog.Builder(Register_Food.this);
                View view1 = LayoutInflater.from(Register_Food.this).inflate(R.layout.register__food_writing, null, false);
                builder1.setView(view1);

                final Button btnRec = view1.findViewById(R.id.button2);
                final Button btnnow = view1.findViewById(R.id.btnnow);

                final ImageButton upload1 = view1.findViewById(R.id.up);
                final Spinner Person = view1.findViewById(R.id.name);
                final TextView now = view1.findViewById(R.id.txt);
                final Spinner food1 = view1.findViewById(R.id.spnFood);
                final Spinner food2 = view1.findViewById(R.id.spnFood2);


                //팝업창에 나타낼 스피너 연결
                setNameSpinner(Person);
                adspin1 = ArrayAdapter.createFromResource(Register_Food.this, R.array.spinner_do, android.R.layout.simple_spinner_dropdown_item);
                adspin1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                adspin2 = ArrayAdapter.createFromResource(com.example.pet_dairy.Register_Food.this, R.array.spinner_do_g, android.R.layout.simple_spinner_dropdown_item);
                adspin3 = ArrayAdapter.createFromResource(com.example.pet_dairy.Register_Food.this,R.array.spinner_do_s, android.R.layout.simple_spinner_dropdown_item);
                food1.setAdapter(adspin1);

                food1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        if (adspin1.getItem(i).equals("건식 사료")) {
                            choice_do = "건식 사료";
                            adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            food2.setAdapter(adspin2);
                            food2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    choice_se = adspin2.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        } else if (adspin1.getItem(i).equals("습식 사료")) {
                            choice_do = "습식 사료";
                            adspin3 = ArrayAdapter.createFromResource(com.example.pet_dairy.Register_Food.this, R.array.spinner_do_s, android.R.layout.simple_spinner_dropdown_item);
                            adspin3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            food2.setAdapter(adspin3);
                            food2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    choice_se = adspin3.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                });

                btnnow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        now.setText(getTime());
                    }
                });
                // 버튼 클릭시 권장 사료량 팝업 창 알림
                btnRec.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(com.example.pet_dairy.Register_Food.this);
                        builder.setTitle("권장 사료량");
                        builder.setMessage("생후~3개월 : 몸무게의 7% \n 3개월~6개월 : 몸무게의 5~7% \n 6개월~12개월 : 몸무게의 4~5% \n 12개월 이상 : 몸무게의 2~3%");
                        builder.setNeutralButton("닫기",null);
                        builder.create().show();
                    }
                });

                //위에 내용들을 가진 팝업 창 생성
                final AlertDialog dialog1 = builder1.create();
                //저장 버튼 클릭 시 파이어베이스에 데이터 저장
                upload1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                        DatabaseReference rootRef = firebaseDatabase.getReference("Pet Care");
                        DatabaseReference foodRef = rootRef.child("food");

                        String strPerson = Person.getSelectedItem().toString();
                        String stnNow = now.getText().toString();
                        String strFood1 = food1.getSelectedItem().toString();
                        String strFood2 = food2.getSelectedItem().toString();

                        Food food = new Food(strPerson, stnNow, strFood1, strFood2);
                        if (strPerson.length() == 0) return;

                        foodRef.push().setValue(food);

                        foodRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                StringBuffer buffer = new StringBuffer();
                                listFood.clear();
                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                    Food food = snapshot.getValue(Food.class);
                                    String strPerson = food.getperson();
                                    String stnNow = food.getnow();
                                    String strFood1 = food.getfood1();
                                    String strFood2 = food.getfood2();
                                    buffer.append(listFood);

                                    listFood.add(food);
                                }
                                adapter1.notifyDataSetChanged();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });
                        dialog1.dismiss(); //팝업 창 닫기
                        Toast.makeText(getApplicationContext(), "저장되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog1.show(); //팝업 창 띄우기
            }
        });
        // 눈 버튼 클릭시 파이어베이스에 저장된 정보들 보여주기
        look1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference rootRef = firebaseDatabase.getReference("Pet Care");
                DatabaseReference foodRef = rootRef.child("food");

                foodRef.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        StringBuffer buffer = new StringBuffer();
                        listFood.clear();

                        for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                            Food food = snapshot.getValue(Food.class);
                            String  strPerson= food.getperson();
                            String  stnNow = food.getnow();
                            String  strFood1 = food.getfood1();
                            String  strFood2= food.getfood2();
                            buffer.append(listFood);

                            listFood.add(food);
                        }

                        adapter1.notifyDataSetChanged();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
        });

    }
    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {
        }
        @Override
        public void onDrawerClosed(@NonNull View drawerView) {
        }
        @Override
        public void onDrawerStateChanged(int newState) {
        }
    };

    private void setNameSpinner(Spinner nameSpinner) { //
        Pet_Database.getPersons(dataSnapshot -> {
            List<String> persons = new ArrayList<>();
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                Person person = snapshot.getValue(Person.class);
                if (person != null) {
                    persons.add(person.name);
                }
            }

            final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(
                    this, android.R.layout.simple_spinner_dropdown_item, persons);
            spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            nameSpinner.setAdapter(spinnerArrayAdapter);
        });
    }
    // 현재 시간을 가져오기 위함 함수
    private String  getTime() {
        long mNow = System.currentTimeMillis();
        Date mDate = new Date(mNow);
        return mFormat.format(mDate);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void sampleMethod() {
    }


}

### 2-4-2 밥 정보 저장 및 리스트 출력
팝업창에 정보를 입력한 후 등록 버튼을 클릭하면 데이터들을 파이어베이스 pat care- food에 저장한다. 리사이클러뷰를 이용하여 저장된 정보를들을 불러와 리스트 형식으로 출력하였다.
눈 버튼을 클릭하면 저장된 리스트들을 볼 수 있다.   
RecyclerAdapter_food - 리사이클러뷰를 출력하기 위한 어댑터
  
    public class RecyclerAdapter_food extends RecyclerView.Adapter<RecyclerAdapter_food.ViewHolder> {
    ArrayList<Food> listFood = new ArrayList<>();
    Context mContext;

    public RecyclerAdapter_food(ArrayList<Food> bundle){
        this.listFood = bundle;
    } //밥 정보 어댑터에 연결

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //리스트 출력 레이아웃 연결
        Context mContext  = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_item_food, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //연결된 레이아웃에 저장된 밥 정보 holder에 연결
        Food food = listFood.get(position);

        holder.PersonView.setText(food.getperson());
        holder.NowView.setText(food.getnow());
        holder.Food1View.setText(food.getfood1());
        holder.Food2View.setText(food.getfood2());
    }

    @Override
    public int getItemCount() {
        return listFood.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView PersonView;
        TextView NowView;
        TextView Food1View;
        TextView Food2View;

        public ViewHolder(@NonNull View View) {
            //리스트을 출력하기 위하 레이아웃에 연결
            super(View);
            PersonView = View.findViewById(R.id.list_person);
            NowView = View.findViewById(R.id.list_now);
            Food1View = View.findViewById(R.id.list_food1);
            Food2View = View.findViewById(R.id.list_food2);
        }
    }
    }
![image](https://user-images.githubusercontent.com/51051548/121146422-de88ba80-c87a-11eb-88fe-07e1bc571b62.png)

***
## 2-5 기능 2 - 간식
### 2-5-1 간식 정보 입력 팝업창
준 사람, 준 시간, 간식 종류, 간식 양을 + 버튼을 통해 입력 할 수 있는 팝업창을 구현하였다.
준 사람, 간식 종류은 스피너로 등록하여 선택 할 수 있게 하였고, 준 시간은 Now 버튼을 클릭 하면 실시간 날짜와 시간을 입력 받을 수 있다. 준 사람 스피너는 앞에서 가족 등록을 통하여 등록된 가족구성원을 선택 할 수 있다.

Register_Snack.java


    public class Register_Snack extends AppCompatActivity {

    private final ArrayList<Snack> listSnack = new ArrayList<>();
    private RecyclerView recyclerView2;
    private RecyclerAdapyer_snack adapter2;
    private  RecyclerView.LayoutManager layoutManager2;

    private FloatingActionButton add2, look2;
    private DrawerLayout drawerLayout;
    private View drawerView;


    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register__snack);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerView = (View)findViewById(R.id.drawer);
        recyclerView2 = (RecyclerView) findViewById(R.id.snack_list);
        recyclerView2.setHasFixedSize(true);
        layoutManager2 = new LinearLayoutManager(this);
        ((LinearLayoutManager) layoutManager2).setReverseLayout(true);
        ((LinearLayoutManager) layoutManager2).setStackFromEnd(true);

        add2 = findViewById(R.id.snackButton2);
        look2 = findViewById(R.id.snackButton);

        recyclerView2.setLayoutManager(layoutManager2);
        adapter2 = new RecyclerAdapyer_snack(listSnack);

        recyclerView2.setAdapter(adapter2);

        //파이어베이스 연결
        FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
        DatabaseReference rootRef = firebaseDatabase.getReference();

        //네비게이션 연결
        Button Btn1 = (Button)findViewById(R.id.Btn1);
        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_f =new Intent(Register_Snack.this,Register_Food.class);
                startActivity(intent_f);
            }
        });
        Button Btn2 = (Button)findViewById(R.id.Btn2);
        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_s =new Intent(Register_Snack.this,Register_Snack.class);
                startActivity(intent_s);
            }
        });
        Button Btn3 = (Button)findViewById(R.id.Btn3);
        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_h =new Intent(Register_Snack.this,Register_Health.class);
                startActivity(intent_h);
            }
        });
        Button Btn4 = (Button)findViewById(R.id.Btn4);
        Btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_r =new Intent(Register_Snack.this,Register_Run.class);
                startActivity(intent_r);
            }
        });

        Button btn_close = (Button)findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawers();
            }
        });

        drawerLayout.setDrawerListener(listener);
        drawerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        
        // + 버튼 클릭 시 입력 팝업 창 생성
        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder2 = new AlertDialog.Builder(Register_Snack.this);
                View view2 = LayoutInflater.from(Register_Snack.this).inflate(R.layout.register__snack_writing, null, false);
                builder2.setView(view2);

                final Button btnDate = view2.findViewById(R.id.btndate);
                final ImageButton upload2 = view2.findViewById(R.id.up);

                final Spinner Give = view2.findViewById(R.id.spnGive);
                final Spinner Type = view2.findViewById(R.id.spnType);
                final TextView Date = view2.findViewById(R.id.txtdate);
                final EditText Many  = view2.findViewById(R.id.txtMany);

                // 팝업창에 나타낼 스피너 연결
                setNameSpinner(Give);
                ArrayAdapter type = ArrayAdapter.createFromResource(Register_Snack.this, R.array.종류, android.R.layout.simple_spinner_dropdown_item);
                type.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                Type.setAdapter(type);

                Type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

                btnDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Date.setText(getTime());
                    }
                });

                // 위에 내용들을 가진 팝업 창 생성
                final AlertDialog dialog2 = builder2.create();
                
                // 저장 버튼 클릭 시 파이어베이스에 데이터 저장
                upload2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                        DatabaseReference rootRef = firebaseDatabase.getReference("Pet Care");
                        DatabaseReference snackRef = rootRef.child("snack");

                        String strGive = Give.getSelectedItem().toString();
                        String strType = Type.getSelectedItem().toString();
                        String strDate = Date.getText().toString();
                        String strMany = Many.getText().toString();

                        Snack snack = new Snack(strGive,strType, strMany, strDate);
                        if (strGive.length() == 0) return;

                        snackRef.push().setValue(snack);

                        snackRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                StringBuffer buffer = new StringBuffer();
                                listSnack.clear();
                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                    Snack snack = snapshot.getValue(Snack.class);
                                    String strGive = snack.getGive();
                                    String strType = snack.getType();
                                    String strDate= snack.getDate();
                                    String strMany = snack.getMany();
                                    buffer.append(listSnack);

                                    listSnack.add(snack);
                                }
                                adapter2.notifyDataSetChanged();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });
                        dialog2.dismiss(); // 팝업 창 닫기
                        Toast.makeText(getApplicationContext(), "저장되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog2.show(); // 팝업 창 띄우기
            }
        });

        // 눈 버튼 클릭시 파이어베이스에 저장된 정보들 보여주기
        look2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference rootRef = firebaseDatabase.getReference("Pet Care");
                DatabaseReference snackRef = rootRef.child("snack");

                snackRef.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        StringBuffer buffer = new StringBuffer();
                        listSnack.clear();
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            Snack snack = snapshot.getValue(Snack.class);
                            String strGive = snack.getGive();
                            String strType = snack.getType();
                            String strDate= snack.getDate();
                            String strMany = snack.getMany();
                            buffer.append(listSnack);

                            listSnack.add(snack);
                        }
                        adapter2.notifyDataSetChanged();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
        });

    }
    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {
        }
        @Override
        public void onDrawerClosed(@NonNull View drawerView) {
        }
        @Override
        public void onDrawerStateChanged(int newState) {
        }
    };

    private void setNameSpinner(Spinner nameSpinner) {
        Pet_Database.getPersons(dataSnapshot -> {
            List<String> persons = new ArrayList<>();
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                Person person = snapshot.getValue(Person.class);
                if (person != null) {
                    persons.add(person.name);
                }
            }

            final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(
                    this, android.R.layout.simple_spinner_dropdown_item, persons);
            spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            nameSpinner.setAdapter(spinnerArrayAdapter);
        });
    }

    // 현재 시간을 가져오기 위함 함수
    private String  getTime() {
        long mNow = System.currentTimeMillis();
        Date mDate = new Date(mNow);
        return mFormat.format(mDate);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void sampleMethod() {
    }


### 2-5-2 간식 정보 저장 및 리스트 출력
팝업창에 정보를 입력한 후 등록 버튼을 클릭하면 데이터들을 파이어베이스 pat care-snack에저장한다. 리사이클러뷰를 이용하여 저장된 정보를들을 불러와 리스트 형식으로 출력하였다.
눈 버튼을 클릭하면 저장된 리스트들을 볼 수 있다.

RecyclerAdapter_snack.java


    public class RecyclerAdapyer_snack extends RecyclerView.Adapter<RecyclerAdapyer_snack.ViewHolder> {
    ArrayList<Snack> listSnack = new ArrayList<>();
    Context mContext;

    public RecyclerAdapyer_snack(ArrayList<Snack> bundle){
        this.listSnack = bundle;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 리스트 출력 레이아웃 연결
        Context mContext  = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_item_snack, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // 연결된 레이아웃에 저장된 밥 정보 holder에 연결
        Snack snack = listSnack.get(position);

        holder.GiveView.setText(snack.getGive());
        holder.TypeView.setText(snack.getType());
        holder.DateView.setText(snack.getDate());
        holder.ManyView.setText(snack.getMany());
    }

    @Override
    public int getItemCount() {
        return listSnack.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView GiveView;
        TextView TypeView;
        TextView DateView;
        TextView ManyView;

        public ViewHolder(@NonNull View View) {
            // 리스트를 출력하기 위해 레이아웃에 연결
            super(View);
            GiveView = View.findViewById(R.id.list_Give);
            TypeView = View.findViewById(R.id.list_Type);
            DateView = View.findViewById(R.id.list_Date);
            ManyView = View.findViewById(R.id.list_Many);
        }
    }


 ![image](https://user-images.githubusercontent.com/79950103/121155748-0e3bc080-c883-11eb-9ad0-23c730a256ab.png)
 
앞서 저장한 가족정보를 스피너로 띄워 간식제공한사람을 입력하고, 간식준 시간을 입력할수있으며   
(now 버튼을 클릭하여 현재시간을 입력받을수 있는 기능도 넣었다.)
 
***
## 2-6 기능 3 - 산책
### 2-6-1 산책 정보 입력 팝업창
산책을 시킨 사람, 시킨 시간, 산책시간, 산책장소를 입력할 수있는 팝업팡을 구현하였다. 또 스피너 기능을 통하여 산책 시킨 사람을 등록한 별명을 통해 선택 입력할 수 있도록 구현을 하였고 시킨 시간은 NOW버튼을 통해 실시간 시간과 날짜를 입력 받을 수 있도록 하였다.   

 
   
   Register_Run.java
    
    public class Register_Run extends AppCompatActivity {

    private final ArrayList<Walk> listRun = new ArrayList<>();
    private  RecyclerView recyclerView2;
    private RecyclerAdapter_run adapter2;
    private  RecyclerView.LayoutManager layoutManager2;
    private DrawerLayout drawerLayout;
    private View drawerView;
    private FloatingActionButton add2, look2;


    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register__run);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerView = (View)findViewById(R.id.drawer);
        recyclerView2 = (RecyclerView) findViewById(R.id.run_list);
        recyclerView2.setHasFixedSize(true);
        layoutManager2 = new LinearLayoutManager(this);
        ((LinearLayoutManager) layoutManager2).setReverseLayout(true);
        ((LinearLayoutManager) layoutManager2).setStackFromEnd(true);

        add2 = findViewById(R.id.runButton2);
        look2 = findViewById(R.id.runButton);

        recyclerView2.setLayoutManager(layoutManager2);
        adapter2 = new RecyclerAdapter_run(listRun);

        recyclerView2.setAdapter(adapter2);

        //파이어베이스 견결
        FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
        DatabaseReference rootRef = firebaseDatabase.getReference();
        
        //네비게이션 연결
        Button Btn1 = (Button)findViewById(R.id.Btn1);
        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_f =new Intent(Register_Run.this,Register_Food.class);
                startActivity(intent_f);
            }
        });
        Button Btn2 = (Button)findViewById(R.id.Btn2);
        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_s =new Intent(Register_Run.this,Register_Snack.class);
                startActivity(intent_s);
            }
        });
        Button Btn3 = (Button)findViewById(R.id.Btn3);
        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_h =new Intent(Register_Run.this,Register_Health.class);
                startActivity(intent_h);
            }
        });
        Button Btn4 = (Button)findViewById(R.id.Btn4);
        Btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_r =new Intent(Register_Run.this,Register_Run.class);
                startActivity(intent_r);
            }
        });

        Button btn_close = (Button)findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawers();
            }
        });

        drawerLayout.setDrawerListener(listener);
        drawerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        //DatabaseReference walkRef = rootRef.child("walk");

        // + 버튼 클릭 시 입력 팝업 창 생성
        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder2 = new AlertDialog.Builder(Register_Run.this);
                View view2 = LayoutInflater.from(Register_Run.this).inflate(R.layout.register__run_writing, null, false);
                builder2.setView(view2);
                
                final Button btnnow = view2.findViewById(R.id.btnnow);
                final Button btn_mate = view2.findViewById(R.id.btn_mate);
                final ImageButton upload2 = view2.findViewById(R.id.up);

                final TextView Now = view2.findViewById(R.id.txtNow);
                final EditText Place = view2.findViewById(R.id.txtplace);
                final Spinner spinner1 = view2.findViewById(R.id.spinner1);
                final Spinner spinner2 = view2.findViewById(R.id.spinner2);
                
                // 팝업창에 나타낼 스피너 연결
                setNameSpinner(spinner1);
                
                ArrayAdapter time = ArrayAdapter.createFromResource(Register_Run.this, R.array.time, android.R.layout.simple_spinner_dropdown_item);
                time.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner2.setAdapter(time);

                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) { }
                });

                btnnow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Now.setText(getTime());
                    }
                });

                btn_mate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), WalkingMate.class);
                        startActivity(intent);
                    }
                });

                //위에 내용들을 가진 팝업 창 생성
                final AlertDialog dialog2 = builder2.create();

                //저장 버튼 클릭 시 파이어베이스에 데이터 저장
                upload2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //산책 정보 저장
                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                        DatabaseReference rootRef = firebaseDatabase.getReference("Pet Care");
                        DatabaseReference walkRef = rootRef.child("walk");

                        String strTime = spinner2.getSelectedItem().toString(); //시간
                        String strPlace = Place.getText().toString(); //장소
                        String strPerson = spinner1.getSelectedItem().toString(); //사람
                        String strDate = Now.getText().toString();  //현재 날짜, 시간


                        Walk walk = new Walk(strTime, strPlace, strPerson, strDate);
                        if (strPerson.length() == 0) return;

                        walkRef.push().setValue(walk);

                        walkRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                StringBuffer buffer = new StringBuffer();
                                listRun.clear();
                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                    Walk walk = snapshot.getValue(Walk.class);
                                    String strTime = walk.getTime();
                                    String strPlace = walk.getPlace();
                                    String strPerson = walk.getPerson();
                                    String strDate = walk.getNow();
                                    buffer.append(listRun);

                                    listRun.add(walk);
                                }
                                adapter2.notifyDataSetChanged();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });
                        dialog2.dismiss(); //팝업 창 닫기
                        Toast.makeText(getApplicationContext(), "저장되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog2.show(); //팝업 창 띄우기
            }
        });

        //눈 버튼 클릭시 파이어베이스에 저장된 보들 보여주기 
        look2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference rootRef = firebaseDatabase.getReference("Pet Care");
                DatabaseReference walkRef = rootRef.child("walk");

                walkRef.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        StringBuffer buffer = new StringBuffer();
                        listRun.clear();
                        for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                            Walk walk = snapshot.getValue(Walk.class);

                            String strTime = walk.getTime();
                            String strPlace = walk.getPlace();
                            String strPerson = walk.getPerson();
                            String strDate = walk.getNow();

                            buffer.append(listRun);

                            listRun.add(walk);
                        }
                        adapter2.notifyDataSetChanged();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
        });
    }
    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {
        }
        @Override
        public void onDrawerClosed(@NonNull View drawerView) {
        }
        @Override
        public void onDrawerStateChanged(int newState) {
        }
    };

    private void setNameSpinner(Spinner nameSpinner) {
        Pet_Database.getPersons(dataSnapshot -> {
            List<String> persons = new ArrayList<>();
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                Person person = snapshot.getValue(Person.class);
                if (person != null) {
                    persons.add(person.name);
                }
            }

            final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(
                    this, android.R.layout.simple_spinner_dropdown_item, persons);
            spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            nameSpinner.setAdapter(spinnerArrayAdapter);
        });
    }

    // 현재 시간을 가져오기 위함 함수
    private String  getTime() {
        long mNow = System.currentTimeMillis();
        Date mDate = new Date(mNow);
        return mFormat.format(mDate);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void sampleMethod() {
    }


### 2-6-2 산책 정보 저장 및 리스트 출력
팝업창에 정보를 입력한 후 등록 버튼을 클릭하면 데이터들을 파이어베이스 pat care- walk에 저장한다. 리사이클러뷰를 이용하여 저장된 정보를들을 불러와 리스트 형식으로 출력하였다.
눈 버튼을 클릭하면 저장된 리스트들을 볼 수 있다.
 
   RecyclerAdapter.java
    
    public class RecyclerAdapter_run extends RecyclerView.Adapter<RecyclerAdapter_run.ViewHolder> {
    ArrayList<Walk> listRun = new ArrayList<>();
    Context mContext;

    public RecyclerAdapter_run(ArrayList<Walk> bundle){
        this.listRun = bundle;
    } // 산책 정보 어댑터에 연결

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //리스트 출력 레이아웃 연결
        Context mContext  = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_item_run, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // 연결된 레이아웃에 저장된 밥 정보 holder에 연결
        Walk walk = listRun.get(position);

        holder.TimeView.setText(walk.getTime());
        holder.PlaceView.setText(walk.getPlace());
        holder.PersonView.setText(walk.getPerson());
        holder.NowView.setText(walk.getNow());
    }

    @Override
    public int getItemCount() {
        return listRun.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView TimeView;
        TextView PlaceView;
        TextView PersonView;
        TextView NowView;

        public ViewHolder(@NonNull View View) {
            // 리스트를 출력하기 위해 레이아웃에 연결
            super(View);
            TimeView = View.findViewById(R.id.list_time);
            PlaceView = View.findViewById(R.id.list_place);
            PersonView = View.findViewById(R.id.list_person);
            NowView = View.findViewById(R.id.list_now);
        }
    }
![image](https://user-images.githubusercontent.com/79950254/121297839-e2294980-c92d-11eb-9a40-c563b3db57e1.png)
   

### 2-6-3 산책 메이트
산책 메이트 찾기 버튼을 누르면 산책 메이트 찾기 게시판이 뜨게 된다. 다른 사람이 등록한 정보를 보고 직접 메이트를 찾을 수 있으며 사용자가 게시판에 입력함으로써 메이트를 구할 수있다.

![image](https://user-images.githubusercontent.com/79950380/121206310-51ae2300-c8b3-11eb-96d2-66fa86687c5d.png)


#### #2-6-3-1 산책 메이트 정보 입력 팝업창
산책장소, 예상시간, 강아지종, 카카오톡ID를 + 버튼 을 통해 입력하는 팝업창을 구현하였다. 예상 시간은 스피너 통해 선택 할 수 있다. 
   
 WalingMate_Board.java
 
    public class WalkingMate_Board extends AppCompatActivity {

    private final ArrayList<Board> listBundle = new ArrayList<>();
    private  RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private  RecyclerView.LayoutManager layoutManager;

    private FloatingActionButton add, look;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.walkingmate_board);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        ((LinearLayoutManager) layoutManager).setReverseLayout(true);
        ((LinearLayoutManager) layoutManager).setStackFromEnd(true);

        add = findViewById(R.id.floatingActionButton2);
        look = findViewById(R.id.floatingActionButton);

        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(listBundle);

        recyclerView.setAdapter(adapter);

        //파이어베이스 연결
        FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
        DatabaseReference rootRef = firebaseDatabase.getReference();

        //파이어베이스 데이터베이스 하위 항목 지정
        DatabaseReference BoardRef = rootRef.child("WalkingBoards");

        // + 버튼 클릭 시 입력 팝업 창 생성
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(WalkingMate_Board.this);
                View view = LayoutInflater.from(WalkingMate_Board.this).inflate(R.layout.walkingmate_board_writing, null, false);
                builder.setView(view);

                final Button upload = view.findViewById(R.id.btnUp1);
                final EditText Plice = view.findViewById(R.id.PliceText);
                final Spinner Time = view.findViewById(R.id.Timetext1);
                final EditText dog  =  view.findViewById(R.id.Dog_breedText);
                final EditText id = view.findViewById(R.id.IDText1);
                
                ArrayAdapter timee = ArrayAdapter.createFromResource(WalkingMate_Board.this, R.array.time, android.R.layout.simple_spinner_dropdown_item);
                timee.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                Time.setAdapter(timee);

                Time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) { }
                });

                //위의 내용들을 가진 팝업 창 생성
                final AlertDialog dialog = builder.create();

                // 저장 버튼 클릭 시 파이어베이스에 데이터 저장
                upload.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String strPlice = Plice.getText().toString();
                        String strTime = Time.getSelectedItem().toString();
                        String strDog = dog.getText().toString();
                        String  strid = id.getText().toString();

                        Board board = new Board(strPlice, strTime, strDog, strid);
                        if(strPlice.length() == 0)return;

                        BoardRef.push().setValue(board);

                        BoardRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                StringBuffer buffer = new StringBuffer();
                                listBundle.clear();
                                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                                    Board board = snapshot.getValue(Board.class);
                                    String  strPlice = board.getPlace();
                                    String strTime = board.getTime();
                                    String strDog = board.getDog_breed();
                                    String  strid = board.getID();
                                    buffer.append(listBundle);

                                    listBundle.add(board);
                                }
                                adapter.notifyDataSetChanged();
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });
                        dialog.dismiss(); // 팝업 창 닫기
                        Toast.makeText(getApplicationContext(),"저장되었습니다. ", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.show(); // 팝업 창 띄우기
            }
        });
        
        // 눈 버튼 클릭 시 파이어베이스에 저장된 정보들 보여주기
        look.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BoardRef.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        StringBuffer buffer = new StringBuffer();
                        listBundle.clear();

                        for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                            Board board = snapshot.getValue(Board.class);
                            String  strPlice = board.getPlace();
                            String strTime = board.getTime();
                            String strDog = board.getDog_breed();
                            String  strid = board.getID();
                            buffer.append(listBundle);

                            listBundle.add(board);
                        }

                        adapter.notifyDataSetChanged();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
        });
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void sampleMethod() {
    }



##### 2-6-3-2 산책 메이트 정보 저장 및 리스트 출력
팝업창에 정보를 입력한 후 등록 버튼을 클릭하면 데이터들을 파이어베이스 WalkingBoards에 저장한다. 리사이클러뷰를 이용하여 저장된 정보를들을 불러와 리스트 형식으로 출력하였다.
눈 버튼을 클릭하면 저장된 리스트들을 볼 수 있다.   
 
 RecyclerAdapter_run.java 
 
    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    ArrayList<Board> listBundle = new ArrayList<>();
    Context mContext;

    public RecyclerAdapter(ArrayList<Board> bundle){
        this.listBundle = bundle;
    } // 산책 정보 어댑터에 연결
    
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 리스트 출력 레이아웃 연결
        Context mContext  = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.walingmate_board_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // 연결된 레이아웃에 저장된 밥 정보 holder에 연결
        Board  board = listBundle.get(position);

        holder.PliceView.setText(board.getPlace());
        holder.TimeView.setText(board.getTime());
        holder.Dog_breedView.setText(board.getDog_breed());
        holder.IDView.setText(board.getID());
    }

    @Override
    public int getItemCount() {
        return listBundle.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView PliceView;
        TextView TimeView;
        TextView Dog_breedView;
        TextView IDView;

        public ViewHolder(@NonNull View View) {
            // 리스트를 출력하기 위해 레이아웃에 연결
            super(View);
            PliceView = View.findViewById(R.id.list_place);
            TimeView = View.findViewById(R.id.list_time);
            Dog_breedView = View.findViewById(R.id.list_Dog_breed);
            IDView = View.findViewById(R.id.list_ID);
        }
    }
 


### 2-6-4 근처 공원 찾기
‘google map’을 이용하여 사용자의 위치를 GPS를 통해 전송받아 위치를 나타내고, google  Place API 을 이용하여 사용자 주변의 가까운 공원들을 검색할 수있도록 하였다.

#### https://console.cloud.google.com/home/dashboard?folder=&organizationId=&project=double-venture-314915

#### Google Maps Android API 발급 받기

 ![image](https://user-images.githubusercontent.com/79950380/121276575-ddeb3500-c909-11eb-98a1-3c9902e8ff9f.png)
 
1. 새 프로젝트를 만들고 Maps SDK for Android 사용 클릭
 
![image](https://user-images.githubusercontent.com/79950380/121276921-8bf6df00-c90a-11eb-98d8-185bd8e50e84.png)

2. 사용자 인증 정보에서 API키 생성 후 수정

![image](https://user-images.githubusercontent.com/79950380/121277344-5bfc0b80-c90b-11eb-88c2-73998f633b35.png)

3. Android앱을 선택하고 패키지 이름과 SHA-1 입력

![image](https://user-images.githubusercontent.com/79950380/121277517-bac18500-c90b-11eb-8a6a-5b40bdca6431.png)

4. google_maps_api.xml "google_maps_key" 부분에 입력

#### Place API 발급 받기

![image](https://user-images.githubusercontent.com/79950380/121277768-463b1600-c90c-11eb-990d-a4a47bc192f7.png)

1. 위의 과정에서 Google Maps Android API 대신 Place API 선택 / 3번 과정 생략

![image](https://user-images.githubusercontent.com/79950380/121278148-ff015500-c90c-11eb-8193-c0c2f3e52d51.png)

2. Register_Health_Find.java와 WalkingMate_map.java key() 부분에 입력

  

WalingMate_map.java

    public class WalkingMate_map extends AppCompatActivity
        implements OnMapReadyCallback, ActivityCompat.OnRequestPermissionsResultCallback, PlacesListener{

    private GoogleMap mMap;
    private Marker currentMarker = null;

    private static final String TAG = "googlemap_example";
    private static final int GPS_ENABLE_REQUEST_CODE = 2001;
    private static final int UPDATE_INTERVAL_MS = 1000;  // 1초
    private static final int FASTEST_UPDATE_INTERVAL_MS = 500; // 0.5초

    private static final int PERMISSIONS_REQUEST_CODE = 100;
    boolean needRequest = false;

    String[] REQUIRED_PERMISSIONS  = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};  // 외부 저장소

    Location mCurrentLocatiion;
    LatLng currentPosition;

    private FusedLocationProviderClient mFusedLocationClient;
    private LocationRequest locationRequest;
    private Location location;
    private View mLayout;

    List<Marker> previous_marker = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.walkingmate_map);

        previous_marker = new ArrayList<Marker>();

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPlaceInformation(currentPosition);
            }
        });

        mLayout = findViewById(R.id.layout_main);

        locationRequest = new LocationRequest()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(UPDATE_INTERVAL_MS)
                .setFastestInterval(FASTEST_UPDATE_INTERVAL_MS);

        LocationSettingsRequest.Builder builder =
                new LocationSettingsRequest.Builder();

        builder.addLocationRequest(locationRequest);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        Log.d(TAG, "onMapReady :");

        mMap = googleMap;

        setDefaultLocation();

        int hasFineLocationPermission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        int hasCoarseLocationPermission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION);

        if (hasFineLocationPermission == PackageManager.PERMISSION_GRANTED &&
                hasCoarseLocationPermission == PackageManager.PERMISSION_GRANTED   ) {

            startLocationUpdates();

        }

        else {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[0])) {

                Snackbar.make(mLayout, "이 앱을 실행하려면 위치 접근 권한이 필요합니다.",
                        Snackbar.LENGTH_INDEFINITE).setAction("확인", new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        ActivityCompat.requestPermissions( WalkingMate_map.this, REQUIRED_PERMISSIONS,
                                PERMISSIONS_REQUEST_CODE);
                    }
                }).show();

            } else {

                ActivityCompat.requestPermissions( this, REQUIRED_PERMISSIONS,
                        PERMISSIONS_REQUEST_CODE);
            }

        }

        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng latLng) {

                Log.d( TAG, "onMapClick :");
            }
        });
    }

    LocationCallback locationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            super.onLocationResult(locationResult);

            List<Location> locationList = locationResult.getLocations();

            if (locationList.size() > 0) {
                location = locationList.get(locationList.size() - 1);
                //location = locationList.get(0);

                currentPosition
                        = new LatLng(location.getLatitude(), location.getLongitude());

                String markerTitle = getCurrentAddress(currentPosition);
                String markerSnippet = "위도:" + String.valueOf(location.getLatitude())
                        + " 경도:" + String.valueOf(location.getLongitude());

                Log.d(TAG, "onLocationResult : " + markerSnippet);

                //현재 위치에 마커 생성하고 이동
                setCurrentLocation(location, markerTitle, markerSnippet);

                mCurrentLocatiion = location;
            }
        }

    };

    private void startLocationUpdates() {

        if (!checkLocationServicesStatus()) {

            Log.d(TAG, "startLocationUpdates : call showDialogForLocationServiceSetting");
            showDialogForLocationServiceSetting();
        } else {

            int hasFineLocationPermission = ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION);
            int hasCoarseLocationPermission = ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION);

            if (hasFineLocationPermission != PackageManager.PERMISSION_GRANTED ||
                    hasCoarseLocationPermission != PackageManager.PERMISSION_GRANTED) {

                Log.d(TAG, "startLocationUpdates : 퍼미션 안가지고 있음");
                return;
            }

            Log.d(TAG, "startLocationUpdates : call mFusedLocationClient.requestLocationUpdates");

            mFusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper());

            if (checkPermission())
                mMap.setMyLocationEnabled(true);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart");

        if (checkPermission()) {

            Log.d(TAG, "onStart : call mFusedLocationClient.requestLocationUpdates");
            mFusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null);

            if (mMap!=null)
                mMap.setMyLocationEnabled(true);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (mFusedLocationClient != null) {

            Log.d(TAG, "onStop : call stopLocationUpdates");
            mFusedLocationClient.removeLocationUpdates(locationCallback);
        }
    }

    public String getCurrentAddress(LatLng latlng) {

        //지오코더... GPS를 주소로 변환
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        List<Address> addresses;

        try {
            addresses = geocoder.getFromLocation(
                    latlng.latitude,
                    latlng.longitude,
                    1);
        } catch (IOException ioException) {
            //네트워크 문제
            Toast.makeText(this, "지오코더 서비스 사용불가", Toast.LENGTH_LONG).show();
            return "지오코더 서비스 사용불가";
        } catch (IllegalArgumentException illegalArgumentException) {
            Toast.makeText(this, "잘못된 GPS 좌표", Toast.LENGTH_LONG).show();
            return "잘못된 GPS 좌표";
        }

        if (addresses == null || addresses.size() == 0) {
            Toast.makeText(this, "주소 미발견", Toast.LENGTH_LONG).show();
            return "주소 미발견";

        } else {
            Address address = addresses.get(0);
            return address.getAddressLine(0).toString();
        }
    }

    public boolean checkLocationServicesStatus() {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    public void setCurrentLocation(Location location, String markerTitle, String markerSnippet) {

        if (currentMarker != null) currentMarker.remove();

        LatLng currentLatLng = new LatLng(location.getLatitude(), location.getLongitude());

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(currentLatLng);
        markerOptions.title(markerTitle);
        markerOptions.snippet(markerSnippet);
        markerOptions.draggable(true);

        currentMarker = mMap.addMarker(markerOptions);

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLng(currentLatLng);
        mMap.moveCamera(cameraUpdate);
    }

    public void setDefaultLocation() {
        LatLng DEFAULT_LOCATION = new LatLng(37.56, 126.97);
        String markerTitle = "위치정보 가져올 수 없음";
        String markerSnippet = "위치 퍼미션과 GPS 활성 요부 확인하세요";

        if (currentMarker != null) currentMarker.remove();

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(DEFAULT_LOCATION);
        markerOptions.title(markerTitle);
        markerOptions.snippet(markerSnippet);
        markerOptions.draggable(true);
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        currentMarker = mMap.addMarker(markerOptions);

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(DEFAULT_LOCATION, 15);
        mMap.moveCamera(cameraUpdate);
    }

    private boolean checkPermission() {

        int hasFineLocationPermission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        int hasCoarseLocationPermission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION);

        if (hasFineLocationPermission == PackageManager.PERMISSION_GRANTED &&
                hasCoarseLocationPermission == PackageManager.PERMISSION_GRANTED   ) {
            return true;
        }
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int permsRequestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grandResults) {

        super.onRequestPermissionsResult(permsRequestCode, permissions, grandResults);
        if (permsRequestCode == PERMISSIONS_REQUEST_CODE && grandResults.length == REQUIRED_PERMISSIONS.length) {

            boolean check_result = true;

            for (int result : grandResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    check_result = false;
                    break;
                }
            }

            if (check_result) {
                startLocationUpdates();
            } else {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[0])
                        || ActivityCompat.shouldShowRequestPermissionRationale(this, REQUIRED_PERMISSIONS[1])) {
                    Snackbar.make(mLayout, "퍼미션이 거부되었습니다. 앱을 다시 실행하여 퍼미션을 허용해주세요. ",
                            Snackbar.LENGTH_INDEFINITE).setAction("확인", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            finish();
                        }
                    }).show();
                } else
                    {

                    Snackbar.make(mLayout, "퍼미션이 거부되었습니다. 설정(앱 정보)에서 퍼미션을 허용해야 합니다. ",
                            Snackbar.LENGTH_INDEFINITE).setAction("확인", new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {

                            finish();
                        }
                    }).show();
                }
            }
        }
    }

    private void showDialogForLocationServiceSetting() {

        AlertDialog.Builder builder = new AlertDialog.Builder(WalkingMate_map.this);
        builder.setTitle("위치 서비스 비활성화");
        builder.setMessage("앱을 사용하기 위해서는 위치 서비스가 필요합니다.\n"
                + "위치 설정을 수정하실래요?");
        builder.setCancelable(true);
        builder.setPositiveButton("설정", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Intent callGPSSettingIntent
                        = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivityForResult(callGPSSettingIntent, GPS_ENABLE_REQUEST_CODE);
            }
        });
        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.create().show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case GPS_ENABLE_REQUEST_CODE:
                //사용자가 GPS 활성 시켰는지 검사
                if (checkLocationServicesStatus()) {
                    if (checkLocationServicesStatus()) {

                        Log.d(TAG, "onActivityResult : GPS 활성화 되있음");

                        needRequest = true;

                        return;
                    }
                }
                break;
        }
    }

    @Override
    public void onPlacesFailure(PlacesException e) {
    }

    @Override
    public void onPlacesStart() {
    }

    @Override
    public void onPlacesSuccess(final List<Place> places) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                for (noman.googleplaces.Place place : places) {

                    LatLng latLng
                            = new LatLng(place.getLatitude()
                            , place.getLongitude());

                    String markerSnippet = getCurrentAddress(latLng);

                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(latLng);
                    markerOptions.title(place.getName());
                    markerOptions.snippet(markerSnippet);
                    Marker item = mMap.addMarker(markerOptions);
                    previous_marker.add(item);

                }

                //중복 마커 제거
                HashSet<Marker> hashSet = new HashSet<Marker>();
                hashSet.addAll(previous_marker);
                previous_marker.clear();
                previous_marker.addAll(hashSet);
            }
        });
    }

    @Override
    public void onPlacesFinished() {

    }

    public void showPlaceInformation(LatLng location)
    {
        mMap.clear();//지도 클리어

        if (previous_marker != null)
            previous_marker.clear();//지역정보 마커 클리어

        new NRPlaces.Builder()
                .listener(WalkingMate_map.this)
                .key("AIzaSyDgXkkVZxZ2u8nOAhtGNjVGFlFkX46zs4M")
                .latlng(location.latitude, location.longitude)//현재 위치
                .radius(2000) //2000 미터 내에서 검색
                .type(PlaceType.PARK) //공원
                .build()
                .execute();
    }

![image](https://user-images.githubusercontent.com/79950380/121206662-9fc32680-c8b3-11eb-9539-08fce46b8a73.png)

***
## 2-7 기능 4 - 건강
### 2-7-1 건강 정보 입력 팝업창


 하단 두개의 버튼 중 건강정보 버튼을 클릭하면 입력날짜 및 반려동물의 건강정보를 입력할수있다.


### 2-7-2 건강 정보 저장 및 리스트 출력
팝업창에 정보를 입력한 후 등록 버튼을 클릭하면 데이터들을 파이어베이스 pat care- health에 저장한다. 리사이클러뷰를 이용하여 저장된 정보를들을 불러와 리스트 형식으로 출력하였다. 또, 눈 버튼을 클릭을 통해서 저장된 리스트들을 확인할 수 있다.


### 2-7-3 근처 병원 찾기
병원찾기 버튼을 클릭 google  Place API 을 이용근처 병원을 찾을 수 있도록 만들었다. 
### 2-7-4 다이어리
 다이어리 페이지에 들어가면 가장 먼저 달력을 볼 수있다. 이 달력에서 원하는 날짜를 선택하면 아래에 간단하게 작성할 수있는 칸이 있다.
### 2-7-5  알림설정
알림 설정 버튼을 클릭하면 원하는 날짜와 시간을 입력받고, 지정된 시간이 되면 알림을 메세지로 알려준다. 어플 사용 시 알람이 울리면 어플 내에서 보여주고 어플 사용하지 않은 상태에서 알림이 울리면 상단바에서 보여준다.

***
## 2-8 기능 네비게이션
메뉴 보기 버튼을 클릭하면 다른 화면으로 이동 할 수 있는 기능이다.’각 버튼에 맞는 액티비티를 연결하여 구현하였다.






