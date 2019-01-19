//child_process
// CP = require('child_process')
// cp = CP.spawn('java', ['-jar', 'java_meets_javascript.jar', '1', '2'])
// cp.stdout.on('data', function(data) {
//     console.log(data.toString());
// });

//

// console.log('Java_meets_javascript.jar')
// java.classpath.push('java_meets_javascript.jar')

// result = java.callStaticMethodSync('Main', 'addition', 1, 2)
// console.log(result)

java = require('java')
java.classpath.push('zkrp.jar')
console.log('zkrp.jar')
proof = java.callStaticMethodSync('com.ing.blockchain.zk.JavaScriptRangeProof', 'generate', '2', '1', '3')
java.callStaticMethodSync('com.ing.blockchain.zk.JavaScriptRangeProof', 'verify', proof)