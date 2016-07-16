#ifndef PHOTOHELPER_H
#define PHOTOHELPER_H
#include <QObject>
#include <QQmlListProperty>
#include <QList>
#include <QDir>
#include <QDebug>
//http://doc.qt.io/qt-5/qtqml-cppintegration-exposecppattributes.html
class PhotoHelper : public QObject
{
    Q_OBJECT
        Q_PROPERTY(QString imagePath READ imagePath WRITE setImagePath NOTIFY imagePathChanged)
        Q_PROPERTY(QString next READ next WRITE setImagePath NOTIFY imagePathChanged)
    public:
        PhotoHelper(QString path);
        void setImagePath(const QString &a) {
            imagePaths.append(a);
        }
        QString imagePath() const {
            return imagePaths.at(count%imagePaths.length());
        }
        QString next() {
            emit imagePathChanged() ;
            count++;
//            qDebug() << imagePaths.at(count%imagePaths.length()) ;
            return imagePaths.at(count%imagePaths.length());
        }
        QString privious() {
            emit imagePathChanged() ;
            count--;
            if(-1 == count)
            {
                count*=-1 ;
            }
//            qDebug() << imagePaths.at(count%imagePaths.length()) ;
            return imagePaths.at(count%imagePaths.length());
        }

        void reSetImagePaths()
        {
            imagePaths.clear();
            foreach(QFileInfo fileInfo,photoHomeDir.entryInfoList())
            {
                //qDebug() << fileInfo.canonicalFilePath() ;
                if(fileInfo.isFile())
                {
                    imagePaths.append(fileInfo.canonicalFilePath());
                }
            }
        }
    signals:
        void imagePathChanged();
    private:
        QList<QString> imagePaths;
        int count;
        QString photoHome ;
        QDir photoHomeDir;
};

#endif // PHOTOHELPER_H
