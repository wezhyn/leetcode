#!/usr/bin/env bash
sign_file=/root/sign

cat ${sign_file} | while read line; do
  eval $(echo $line | awk '{printf("ID=%s; PROVINCE=%s; CITY=%s; COUNTRY=%s", $1,$2,$3,$4)}')

  wget -d --no-check-certificate --method POST --timeout=0 --header 'User-Agent: Mozilla/5.0 (Linux; Android 6.0.1; Moto G (4)) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Mobile Safari/537.36' --header 'Referer: https://v-xxtb.zust.edu.cn/web/mobile37/' --header 'Origin: https://v-xxtb.zust.edu.cn' --header 'Accept: application/json' --header 'Content-Length: 441' --header 'Accept-Language: zh-cn' --header 'Content-Type: application/x-www-form-urlencoded' --body-data "id=$ID&user_type=1&environment_type=101&student_id=$ID&state=1&is_body_ok=1&is_gl=0&is_tl=0&is_jc=0&is_2_man=0&is_family=0&user_location=1&location_province=$PROVINCE&location_city=$CITY&location_country=$COUNTRY&morning_state=1&morning_temperature=&afternoon_state=1&afternoon_temperature=&is_jkm=1&r_id=170&round=&module_id=63" 'https://v-xxtb.zust.edu.cn/api/Ncov2019/update_record_student'
done
