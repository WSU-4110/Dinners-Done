import userLogger from './UserLogged.js'

export default function firstLog() {
    userLogger.printLogCount()
    userLogger.log('File')
    userLogger.printLogCount()
}