const csvContent = `StudentID,first_name,last_name,LAB WORK 1,LAB WORK 2,LAB WORK 3,PRELIM EXAM,ATTENDANCE GRADE
073900438,Osbourne,Wakenshaw,69,5,52,12,78
114924014,Albie,Gierardi,58,92,16,57,97
111901632,Eleen,Pentony,43,81,34,36,16
084000084,Arie,Okenden,31,5,14,39,99
272471551,Alica,Muckley,49,66,97,3,95
104900721,Jo,Burleton,98,94,33,13,29
111924392,Cam,Akram,44,84,17,16,24
292970744,Celine,Brosoli,3,15,71,83,45
107004352,Alan,Belfit,31,51,36,70,48
071108313,Jeanette,Gilvear,4,78,15,69,69
042204932,Ethelin,MacCathay,48,36,23,1,11
111914218,Kakalina,Finnick,69,5,65,10,8
074906059,Mayer,Lorenzetti,36,30,100,41,92
091000080,Selia,Rosenstengel,15,42,85,68,28
055002480,Dalia,Tadd,84,86,13,91,22
063101111,Darryl,Doogood,36,3,78,13,100
071908827,Brier,Wace,69,92,23,75,40
322285668,Bucky,Udall,97,63,19,46,28
103006406,Haslett,Beaford,41,32,85,60,61
104913048,Shelley,Spring,84,73,63,59,3
111928373,Aleen,Arnaudin,32,97,55,1,6
264101166,Adeline,Broske,27,51,8,43,15
117006830,Lindsy,Kiffin,86,76,37,18,63
284244222,Bernadine,Aindrais,67,1,72,55,67
051906263,Corinna,Siveyer,41,99,44,53,62
061303847,Ewan,Rehorek,37,56,8,55,10
254070268,Guthrey,Paskins,32,71,32,85,38
254240751,Meris,Strowlger,17,45,39,15,42
112902359,Stacie,Bebis,1,28,40,79,15
101904124,Guntar,Bessant,1,23,19,65,58
111904660,Viviene,Lowndes,11,76,30,76,82
254101188,Sheridan,Vlasyev,82,31,64,31,44
252115162,Adora,Wavish,70,89,84,38,72
262471649,Donny,Pankhurst,1,90,39,14,35
274070387,Elisha,Lafferty,46,67,41,11,8
071018241,Odie,Wiltshaw,57,37,84,23,43
117003023,Bernadene,Bessant,35,9,80,68,91
091103721,Cheryl,Zanini,42,88,14,79,89
112111581,Ilaire,Lowre,39,12,30,71,87
103004313,Helsa,Venn,67,73,83,73,50
061000010,Saree,Bartolomeo,61,66,61,86,22
101902264,Orel,Morpeth,64,74,38,8,62
117001429,Halsy,Swinburne,26,45,71,10,34
071101918,Danyette,Kimmitt,15,55,14,7,78
031102910,Marilee,Thackeray,88,5,18,34,57
034000034,Ameline,Atwill,48,22,6,64,68
284240656,Brade,Swire,82,23,54,80,97
114101144,Brier,Fursdon,21,12,50,56,86
101901111,Iain,De Paoli,16,14,24,6,61
282973161,Linn,Farnie,94,84,10,48,100
112901111,Garreth,Jovovic,64,52,70,72,56
274241111,Brantley,D'Onofrio,28,15,8,91,37
272471111,Eadie,McGinney,42,23,28,4,84
254241111,Pattie,Lowensohn,48,84,14,94,20
111904444,Hillyer,Waltham,48,93,5,69,96
112903333,Alfie,Yakovlev,75,41,40,66,62
114102222,Tanny,Burchfield,62,49,58,47,94
051010101,Bennie,Farryn,63,94,40,93,92
091102222,Roderigo,Labbett,55,16,21,15,22
104903333,Gail,MacCleod,43,15,10,61,25
071105555,Roselin,McGirr,54,34,16,63,90
042207777,Kipp,Stanyon,25,97,83,27,51
111918888,Derron,Goodwin,11,9,41,1,34
074902222,Yuri,Gethins,57,59,96,22,46
091004444,Gaven,Simms,46,65,7,79,16
055006666,Sasha,Jorgensen,54,5,68,26,17
063102222,Aidan,Ruddock,81,19,45,28,68
071901111,Arlan,MacSween,84,54,19,63,80
322281111,Stephan,Nuthall,74,32,49,94,89
103002222,Clerc,Cousans,95,7,32,32,97
104911111,Mandy,Andrzej,71,79,27,24,96
073900438,Osbourne,Wakenshaw,69,5,52,12,78
114924014,Albie,Gierardi,58,92,16,57,97
111901632,Eleen,Pentony,43,81,34,36,16
084000084,Arie,Okenden,31,5,14,39,99
272471551,Alica,Muckley,49,66,97,3,95
104900721,Jo,Burleton,98,94,33,13,29
111924392,Cam,Akram,44,84,17,16,24
292970744,Celine,Brosoli,3,15,71,83,45
107004352,Alan,Belfit,31,51,36,70,48
071108313,Jeanette,Gilvear,4,78,15,69,69
042204932,Ethelin,MacCathay,48,36,23,1,11
111914218,Kakalina,Finnick,69,5,65,10,8
074906059,Mayer,Lorenzetti,36,30,100,41,92
091000080,Selia,Rosenstengel,15,42,85,68,28
055002480,Dalia,Tadd,84,86,13,91,22
063101111,Darryl,Doogood,36,3,78,13,100
071908827,Brier,Wace,69,92,23,75,40
322285668,Bucky,Udall,97,63,19,46,28
103006406,Haslett,Beaford,41,32,85,60,61
104913048,Shelley,Spring,84,73,63,59,3
11192816,Maurise,Schuricht,84,91,26,60,44
121031673,Marian,Steljes,38,96,68,76,79
071025661,Gregory,Kyston,97,10,30,35,30
253184472,Mitchell,Kinglake,71,87,69,93,73
063105544,Axe,Crepel,65,81,17,76,71
274070439,Ronni,Causbey,89,16,87,33,64
067015724,Mira,Robberts,14,29,47,53,69
031317380,Briggs,Strut,33,24,69,59,62
091303376,Siegfried,Kingwell,28,76,96,57,49
064000185,Lotta,Iacomi,96,78,8,81,89
282974161,Caitrin,Waszczyk,74,21,75,31,23
031318596,Issy,Kornyshev,44,58,87,59,9
114921949,Rowney,Tassell,54,43,15,67,10`;

let studentData = csvContent.trim().split('\n').slice(1).map(row => {
    const cols = row.split(',');
    return {
        id: cols[0],
        fname: cols[1],
        lname: cols[2],
        lw1: cols[3],
        lw2: cols[4],
        lw3: cols[5],
        prelim: cols[6],
        att: cols[7]
    };
});

const tableBody = document.getElementById('tableBody');
const studentForm = document.getElementById('studentForm');
const searchBar = document.getElementById('searchBar');

function render(dataToDisplay = studentData) {
    tableBody.innerHTML = ''; 
    
    dataToDisplay.forEach((student, index) => {
    
        const originalIndex = studentData.indexOf(student);
        
        const rowHTML = `
            <tr>
                <td><strong>${student.id}</strong></td>
                <td>${student.fname} ${student.lname}</td>
                <td>${student.lw1}</td>
                <td>${student.lw2}</td>
                <td>${student.lw3}</td>
                <td>${student.prelim}</td>
                <td>${student.att}</td>
                <td>
                    <button class="btn btn-del" onclick="deleteEntry(${originalIndex})">Delete</button>
                </td>
            </tr>
        `;
        tableBody.insertAdjacentHTML('beforeend', rowHTML);
    });
}

studentForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const newStudent = {
        id: document.getElementById('sid').value,
        fname: document.getElementById('fname').value,
        lname: document.getElementById('lname').value,
        lw1: document.getElementById('lw1').value,
        lw2: document.getElementById('lw2').value,
        lw3: document.getElementById('lw3').value,
        prelim: document.getElementById('prelim').value,
        att: document.getElementById('att').value
    };
    studentData.unshift(newStudent); 
    studentForm.reset();
    render();
});


function deleteEntry(index) {
    if(confirm("Are you sure you want to delete this student?")) {
        studentData.splice(index, 1);
        render();
    }
}


searchBar.addEventListener('input', (e) => {
    const term = e.target.value.toLowerCase();
    const filtered = studentData.filter(s => 
        s.fname.toLowerCase().includes(term) || 
        s.lname.toLowerCase().includes(term) || 
        s.id.includes(term)
    );
    render(filtered);
});

render();