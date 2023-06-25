### static content
- static content: html, css, javascript, image, font
- static content는 controller를 거치지 않고 바로 브라우저에 전달
- static content는 \`resources:static/{contentName}\` 경로를 찾아서 처리
- static content는 캐싱이 가능
- static content는 변경이 잦지 않은 정적인 파일
- static content는 브라우저에서 바로 실행 가능
- 파일을 그대로 전달
### mvc & template engine
- mvc: model, view, controller
- template engine: thymeleaf, freemarker, velocity, groovy template
- spring boot에서는 thymeleaf를 기본으로 제공
- thymeleaf: html을 그대로 사용하면서 확장자만 변경
- thymeleaf는 html을 파싱해서 변환
- rendering이 끝난 html을 브라우저에 전달

### API 전달 방식
- 객체를 반환하는 방식
- API: json, xml, text, csv
- \`@ResponseBody\`를 사용하면 viewResolver를 사용하지 않음
- \`@ResponseBody\`를 사용하면 viewResolver 대신에 HttpMessageConverter가 동작
01- 기본 문자처리: StringHttpMessageConverter
