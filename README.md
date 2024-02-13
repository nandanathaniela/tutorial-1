## Module 1
REFLEKSI 1

-prinsip clean code : nama variabel simple dan jelas, fungsi yang dibuat tidak panjang dan jelas sehingga bisa dibaca dan dipahami tanpa perlu comment
-praktek security code : mengimplementasikan metode http yang sesuai
-kesusahan selama mengerjakan : kesusahan yang dialami adalah saat ingin menghapus delete nya menggunakan metode get yang seharusnya menggunakan post

REFLEKSI 2
1. percaya diri dan yakin kode yg ditulis berfungsi dengan baik. jumlah unit test buat satu kelas bisa beda-beda tergantung kompleksitasnya, mungkin setidaknya ada satu test case buat tiap metode. code coverage 100% bukan berarti tidak ada bug sama sekali, hanya mengartikan setiap baris kode dijalankan


## Module 2
You have implemented a CI/CD process that automatically runs the test suites, analyzes code quality, and deploys to a PaaS. Try to answer the following questions in order to reflect on your attempt completing the tutorial and exercise.
1. List the code quality issue(s) that you fixed during the exercise and explain your strategy on fixing them.
- Masalah pertama `This utility class has a non-private constructor` yang mengindikasikan class constructor tidak bersifat private.
- Masalah kedua `Avoid the use of value annotations when its the only element` yang artinya tidak menggunakan `value` dalam annotation jika salah satu elemennya.
- Masalah ketiga `RUN chmod +x gradlew` harus menjalankan itu, jika tidak, gradlew tidak akan execute.
2. Look at your CI/CD workflows (GitHub)/pipelines (GitLab). Do you think the current implementation has met the definition of Continuous Integration and Continuous Deployment? Explain the reasons (minimum 3 sentences)!
- CI (Continuous Integration), CI mengatur kode secara teratur ke dalam repository bersama dan menjalankan tes secara otomatis untuk mendeteksi error dengan cepat.
- CD (Continuous Deployment), CD melewati CI dengan cara otomatis menerapkan perubahan kode ke production setelah lulus uji kode. Jika CD dapat melalui tahapan pengujian, staging, dan produksi, serta memberikan perubahan kode dengan campur tangan manual yang minimal, maka itu mencerminkan implementasi CD yang kuat.