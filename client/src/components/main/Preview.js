import styled from "styled-components";

const Preview = ({ tag, title, content, writer }) => {
    return (
        <Post>
            <div className="tag">기타</div>
            <div className="title">{title}</div>
            <div className="content">
                {content.slice(0, 63)}
                {content.length > 62 ? "..." : null}
            </div>
            <div className="writerContainer">
                <span className="circle"></span>
                <span className="writer">{writer}</span>
                <span className="writerTxt">&nbsp;님</span>
            </div>
            <button>보러가기</button>
        </Post>
    );
};

export default Preview;

const Post = styled.div`
    background-color: var(--lightgreen2);
    width: 276px;
    height: 290px;
    border-radius: 10px;
    padding: 25px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;

    .tag {
        background-color: var(--white);
        border-radius: 10px;
        width: 65px;
        padding: 5px;
        color: var(--green);
        text-align: center;
        font-size: var(--font-body-size);
    }

    .title {
        padding-top: 15px;
        font-weight: var(--font-bold);
        color: var(--darkgreen);
        line-height: 120%;
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-line-clamp: 1;
        -webkit-box-orient: vertical;

        word-wrap: break-word;
        word-break: break-all;
    }

    .content {
        padding-top: 15px;
        font-size: 13px;
        height: 120px;
        line-height: 20px;
        color: var(--darkgreen);
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-line-clamp: 5;
        -webkit-box-orient: vertical;

        word-wrap: break-word;
        word-break: break-all;
    }

    .writerContainer {
        padding-bottom: 12px;
        display: flex;
        justify-content: right;

        .circle {
            background-color: var(--green);
            width: 12px;
            border-radius: 50%;
            margin-right: 5px;
        }
        .writer {
            font-size: var(--font-body-size);
            color: var(--darkgreen);
            font-weight: var(--font-bold);
        }
        .writerTxt {
            font-size: var(--font-body-size);
            color: var(--darkgreen);
        }
    }
`;
