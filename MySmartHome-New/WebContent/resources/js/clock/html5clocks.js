var BaseClock=function(){function n(t,n,r,i,s,o,u){var a=new Date;if(t!=null)a.setYear(t);if(n!=null)a.setMonth(n-1);if(r!=null)a.setDate(r);if(i!=null)a.setHours(i);if(s!=null)a.setMinutes(s);if(o!=null)a.setSeconds(o);e=a.getTime();document.write('<style type="text/css">body{ margin: 0px; padding:0px; }</style>')}var e,t;n.prototype.initAdImage=function(e,t,n,r,i,s,o,u,a){var f=new Image;f.addEventListener("load",function(r){var l=false;var c=0;var h=12;var p=document.createElement("div");var d=document.createElement("canvas");var v=d.getContext("2d");var m=function(){if(l&&c<h){d.style.opacity=Math.sin(Math.PI/2*++c/h);setTimeout(m,1e3/24)}};var g=function(){if(!l&&c>0){d.style.opacity=Math.sin(Math.PI/2*--c/h);setTimeout(g,1e3/36)}};var y=function(e,t,n,r){parameters={r_clock:"html5-"+e+"-"+t,r_link:r,r_adnumber:n};b(parameters)};var b=function(e){queryString="";for(var t in e){queryString+=t+"="+encodeURIComponent(e[t])+"&"}var n=null;if(window.XMLHttpRequest){n=new XMLHttpRequest}else{n=new ActiveXObject("Microsoft.XMLHTTP")}n.open("POST","/scripts/PSP/ClockLink/ClickMan.dll",true);n.setRequestHeader("Content-type","application/x-www-form-urlencoded");n.onreadystatechange=function(){if(n.readyState==4){if(n.status==200){console.log(n.responseText)}}};n.send(queryString)};p.style.position="absolute";p.style.top="0";p.style.left="0";p.style.cursor="pointer";d.width=t;d.height=n;d.style.opacity=0;v.translate(d.width/2,d.height/2);v.scale(u/a,u/a);v.drawImage(f,-f.width/2,-f.height/2);p.addEventListener("click",function(){y(s,o,e,i);window.open(i,"_blank")},false);p.addEventListener("mouseover",function(){l=true;m()},false);p.addEventListener("mouseout",function(){l=false;g()},false);p.id="ad";p.appendChild(d);document.body.appendChild(p)},false);f.src=r};n.prototype.countTime=function(n){t=new Date;t.setTime(e+n);return{day:t.getDay(),year:t.getFullYear(),month:t.getMonth()+1,date:t.getDate(),hour:t.getHours(),minute:t.getMinutes(),second:t.getSeconds(),millisecond:t.getMilliseconds()}};n.prototype.getTime=function(){return t.getTime()};return n}()